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

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

@SuppressWarnings("serial")
public class ConfigurableSystemOutBolt extends BaseBasicBolt {

  public double someFloat;

  public void execute(Tuple tuple, BasicOutputCollector collector) {
    System.out.println( "someFloat is: " + someFloat
            + " tuple passed is: " + tuple);
  }

  public void declareOutputFields(OutputFieldsDeclarer ofd) {
  }

}
