/*
 * #%L
 * servo
 * %%
 * Copyright (C) 2011 Netflix
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

import com.netflix.servo.MetricConfig;

/**
 * A filter to restrict the set of metrics that are polled.
 */
public interface MetricFilter {
    /**
     * Check if a metric with the provided configuration should be selected and
     * sent to observers.
     *
     * @param config  config settings associated with the metric
     * @return        true if the metric should be selected
     */
    boolean matches(MetricConfig config);
}
