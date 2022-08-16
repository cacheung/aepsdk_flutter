/*
Copyright 2022 Adobe. All rights reserved.
This file is licensed to you under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy
of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under
the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
OF ANY KIND, either express or implied. See the License for the specific language
governing permissions and limitations under the License.
*/

package com.adobe.marketing.mobile.flutter.flutter_aepedgeidentity;

import com.adobe.marketing.mobile.edge.identity.IdentityMap;
import com.adobe.marketing.mobile.edge.identity.IdentityItem;
import com.adobe.marketing.mobile.edge.identity.AuthenticatedState;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.reflect.Array;


class FlutterAEPEdgeIdentityDataBridge {

    private final static String ID_KEY = "id";
    private final static String IS_PRIMARY_KEY = "primary";
    private final static String AEP_AUTH_STATE_KEY = "authenticatedState";
    private static final String IDENTITY_MAP_KEY = "identityMap";

    static Map mapFromIdentityMap(final IdentityMap map) {
        if (map == null) {
            return null;
        }

        if (map.isEmpty()){
            return new HashMap<>();
        }

        Map identityMapAsWritableMap = new HashMap<>();

            for (String namespace : map.getNamespaces()) {
                List<IdentityItem> items = map.getIdentityItemsForNamespace(namespace);
                List itemsAsArray = new ArrayList();

                for (IdentityItem item : items) {
                    Map itemMap = new HashMap<>();

                    itemMap.put(IS_PRIMARY_KEY, item.isPrimary());
                    itemMap.put(AEP_AUTH_STATE_KEY, item.getAuthenticatedState().getName());
                    itemMap.put(ID_KEY, item.getId());

                    itemsAsArray.add(itemMap);
                }

                if (itemsAsArray.size() != 0) {
                    identityMapAsWritableMap.put(namespace, itemsAsArray);
                }
            }
        return identityMapAsWritableMap;
    }

    static IdentityMap mapToIdentityMap(final Map map) {

        if (map == null) {
            return null;
        }

        IdentityMap identityMapFromFlutterMap = new IdentityMap();
        Object mapValue = map.get(IDENTITY_MAP_KEY);

        Map convertObjToMap = ((Map) mapValue);





        Iterator<Map.Entry<String, Object>> itr = convertObjToMap.entrySet().iterator();

//        for (Iterator<String> name = mapValue.iterator();
//             name.hasNext();)
//
//
//        ReadableMap mapValue = map.getMap(IDENTITY_MAP_KEY);
//
//        ReadableMapKeySetIterator iterator =  mapValue.keySetIterator();
//
//        //iterate namespaces list
//        while (iterator.hasNextKey()){
//            String namespace  = iterator.nextKey();
//            ReadableArray namespaceArray  = mapValue.getArray(namespace);
//
//            //iterate items
//            for (int i = 0; i < namespaceArray.size(); i++) {
//
//                Map itemsAsMap = namespaceArray.getMap(i);
//
//                IdentityItem item = mapToIdentityItem(itemsAsMap);
//                if (item != null)
//
//                    identityMapFromFlutterMap.addItem(item, namespace);
//            }
//        }

        return identityMapFromFlutterMap;
    }

//    static IdentityItem mapToIdentityItem(Map map) {
//        if (map == null) {
//            return null;
//        }
//
//        String id = getNullableString(map, ID_KEY);
//        // verify id is not null as this is not an accepted value for ids
//        if (id == null) {
//            return null;
//        }
//
//        return new IdentityItem(id, getAuthenticatedState(map, AEP_AUTH_STATE_KEY), getBooleanOrDefaultFalse(map, IS_PRIMARY_KEY));
//    }

     // Helper methods

     private static AuthenticatedState getAuthenticatedState(final Map data, final String key) {
        return AuthenticatedState.fromString(String.valueOf(data.containsKey(key) ? data.containsValue(key) : null));
    }

    private static String getNullableString(final Map data, final String key) {
        return data.containsKey(key) && (data.get(key) instanceof String) ? (String) data.get(key) : null;
    }


//    private static Boolean getBooleanOrDefaultFalse(final Map data, final String key) {
//        return data.containsKey(key) && data.getType(key) == (data.get(key) instanceof Boolean);
//    }
}