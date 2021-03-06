/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.saga.core;

import java.util.Map;
import java.util.Set;

public class SagaStartedEvent extends SagaEvent {

  private final String requestJson;

  public SagaStartedEvent(String sagaId, String requestJson, SagaRequest request) {
    super(sagaId, request);
    this.requestJson = requestJson;
  }

  @Override
  public void gatherTo(
      Map<String, SagaRequest> hangingTransactions,
      Set<String> abortedTransactions,
      Set<String> completedTransactions,
      Set<String> completedCompensations) {

    completedTransactions.add(payload().id());
  }

  @Override
  public String json(ToJsonFormat toJsonFormat) {
    return requestJson;
  }

  @Override
  public String toString() {
    return "SagaStartedEvent{id="
        + payload().id()
        + ", sagaId=" + sagaId
        + "}";
  }
}
