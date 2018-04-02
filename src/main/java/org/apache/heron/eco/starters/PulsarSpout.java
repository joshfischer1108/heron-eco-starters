package org.apache.heron.eco.starters;

import backtype.storm.tuple.Values;
import org.apache.pulsar.client.api.*;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;

import java.util.Map;

public class PulsarSpout extends BaseRichSpout {

    private ConsumerConfiguration consumerConfiguration;

    private PulsarClient pulsarClient;

    private Consumer pulsarConsumer;

    private String pulsarBrokerRootUrl;

    private String pulsarTopic;

    private String pulsarSubscription;

    private SpoutOutputCollector collector;

    public void setConsumerConfiguration(ConsumerConfiguration consumerConfiguration) {
        this.consumerConfiguration = consumerConfiguration;
    }

    public void setPulsarBrokerRootUrl(String pulsarBrokerRootUrl) {
        this.pulsarBrokerRootUrl = pulsarBrokerRootUrl;
    }

    public void setPulsarTopic(String pulsarTopic) {
        this.pulsarTopic = pulsarTopic;
    }

    public void setPulsarSubscription(String pulsarSubscription) {
        this.pulsarSubscription = pulsarSubscription;
    }

    public void open(Map<String, Object> conf, TopologyContext context, SpoutOutputCollector collector) {
        try {
            this.pulsarClient = PulsarClient.create(this.pulsarBrokerRootUrl);
            this.pulsarConsumer = pulsarClient.subscribe(this.pulsarTopic, this.pulsarSubscription);
        } catch (PulsarClientException e) {
            e.printStackTrace();
        }
        this.collector = collector;
    }

    public void nextTuple() {
        //while (true) {

            // Wait for a message
            try {
                Message msg = pulsarConsumer.receive();

                collector.emit(new Values(msg));
                pulsarConsumer.acknowledge(msg);
            } catch (PulsarClientException pse) {
                System.out.println("Exception receiving from client.");
            }
        //}

    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("message"));

    }
}
