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

package org.apache.shardingsphere.transaction.xa.spi;

import org.apache.shardingsphere.spi.type.required.RequiredSPI;
import org.apache.shardingsphere.spi.type.typed.StatefulTypedSPI;

import javax.sql.XADataSource;
import javax.transaction.TransactionManager;

/**
 * XA transaction manager provider.
 */
public interface XATransactionManagerProvider extends AutoCloseable, StatefulTypedSPI, RequiredSPI {
    
    /**
     * Initialize XA transaction manager provider.
     */
    void init();
    
    /**
     * Register recovery resource.
     *
     * @param dataSourceName data source name
     * @param xaDataSource XA data source
     */
    void registerRecoveryResource(String dataSourceName, XADataSource xaDataSource);
    
    /**
     * Remove recovery resource.
     *
     * @param dataSourceName data source name
     * @param xaDataSource XA data source
     */
    void removeRecoveryResource(String dataSourceName, XADataSource xaDataSource);
    
    /**
     * Enlist single XA resource.
     * 
     * @param singleXAResource single XA resource
     */
    void enlistResource(SingleXAResource singleXAResource);
    
    /**
     * Get transaction manager.
     * 
     * @return transaction manager
     */
    TransactionManager getTransactionManager();
}
