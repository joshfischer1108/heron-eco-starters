//  Copyright 2018 Twitter. All rights reserved.
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//  http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
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

public class ConfigurableFibonacciSpout extends BaseRichSpout {

    private static final Logger LOG = Logger.getLogger(ConfigurableFibonacciSpout.class.getName());
    private SpoutOutputCollector collector;
    private String fieldName;

    public ConfigurableFibonacciSpout() {
    }

    public ConfigurableFibonacciSpout(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void configureSpout(String fieldName) {
        this.fieldName = fieldName;
    }

    public void open(Map<String, Object> conf, TopologyContext context,
                     SpoutOutputCollector collector) {
        this.collector = collector;
    }

    public void nextTuple() {
        Utils.sleep(100);
        final int[] words = new int[] {0, 1, 2, 3, 5, 8, 13, 21, 34};
        final Random rand = new Random();
        final int number = words[rand.nextInt(words.length)];

        LOG.info("Emitting: number " + number);
        collector.emit(new Values(number));
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields(fieldName));
    }
}