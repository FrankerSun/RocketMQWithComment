/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.client.latency;

public interface LatencyFaultTolerance<T> {

    /**
     * @param name brokerName
     * @param currentLatency 延迟
     * @param notAvailableDuration 不可用时间
     */
    void updateFaultItem(final T name, final long currentLatency, final long notAvailableDuration);

    boolean isAvailable(final T name);

    void remove(final T name);

    /**
     * 选择队列前一半中一个，也就是相对来说比较好的队列
     */
    T pickOneAtLeast();
}
