/*
 * #%L
 * servo
 * %%
 * Copyright (C) 2011 - 2012 Netflix
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.netflix.servo.publish;

import com.netflix.servo.BasicMonitorRegistry;
import com.netflix.servo.Metric;
import com.netflix.servo.MetricConfig;
import com.netflix.servo.MonitorRegistry;
import com.netflix.servo.annotations.DataSourceType;
import com.netflix.servo.tag.BasicTag;
import com.netflix.servo.tag.BasicTagList;
import com.netflix.servo.tag.TagList;
import com.netflix.servo.util.BasicCounter;
import org.testng.annotations.Test;

import static com.netflix.servo.publish.BasicMetricFilter.*;
import static org.testng.Assert.*;

public class MonitorRegistryMetricPollerTest {

    @Test
    public void testBasic() throws Exception {
        MonitorRegistry registry = new BasicMonitorRegistry();
        registry.registerObject(new BasicCounter("foo"));

        MetricPoller poller = new MonitorRegistryMetricPoller(registry);
        Metric metric = poller.poll(MATCH_ALL).get(0);
        TagList tags = BasicTagList.copyOf(
            new BasicTag("MonitorId", "foo"),
            new BasicTag("ClassName", "com.netflix.servo.util.BasicCounter"),
            DataSourceType.COUNTER);
        assertEquals(metric.getConfig(), new MetricConfig("Count", tags));
    }

}
