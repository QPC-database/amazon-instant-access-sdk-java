/*
 * Copyright 2017-2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.dtasdk.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Contains all the operations supported by Amazon Instant Access
 */
public enum InstantAccessOperationValue {
    PURCHASE("Purchase"),
    REVOKE("Revoke"),
    GETUSERID("GetUserId"),
    SUBSCRIPTIONGET("SubscriptionGet"),
    SUBSCRIPTIONACTIVATE("SubscriptionActivate"),
    SUBSCRIPTIONDEACTIVATE("SubscriptionDeactivate"),
    SUBSCRIPTIONUPDATE("SubscriptionUpdate");

    private String apiName;

    /**
     * @param apiName
     *            The string representation of the operation according to the API
     */
    InstantAccessOperationValue(String apiName) {
        this.apiName = apiName;
    }

    @JsonValue
    public String toJson() {
        return apiName;
    }

    @JsonCreator
    public static InstantAccessOperationValue fromJson(String text) {
        // ignore the case when deserializing
        return valueOf(text.toUpperCase());
    }
}
