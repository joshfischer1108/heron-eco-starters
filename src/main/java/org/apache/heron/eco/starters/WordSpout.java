package org.apache.heron.eco.starters;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public class WordSpout extends BaseRichSpout {

    private static final Logger LOG = Logger.getLogger(ConfigurableFibonacciSpout.class.getName());
    private SpoutOutputCollector collector;

    public void open(Map<String, Object> conf, TopologyContext context,
                     SpoutOutputCollector collector) {
        this.collector = collector;
    }

    public void nextTuple() {
        Utils.sleep(100);
        final String[] words = new String[] {"car", "truck", "dog", "penguin", "wrench", "word", "hat", "poodle", "bird"};
        final Random rand = new Random();
        final String word = words[rand.nextInt(words.length)];

        LOG.info("Emitting: word " + word);
        collector.emit(new Values(word));
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));
    }
}