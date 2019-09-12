这是另外一套配置，但是没有配置成功，后续有机会再启动，现在使用MorphiaDatastore中的bean

下面是这套配置的spring bean文件
```
  <!-- ****************************************** 配置 MongoDB - Start ****************************************** -->
  <!-- mongoDB的配置对象 -->
  <bean id="mongoOptions" class="com.mongodb.MongoOptions">
    <property name="connectionsPerHost" value="10" />
    <!-- 连接超时时间(毫秒)，默认为10000 -->
    <property name="connectTimeout" value="10000" />
    <!-- 是否创建一个finalize方法，以便在客户端没有关闭DBCursor的实例时，清理掉它。默认为true -->
    <property name="cursorFinalizerEnabled" value="true" />
    <!-- 线程等待连接可用的最大时间(毫秒)，默认为120000 -->
    <property name="maxWaitTime" value="120000" />
    <!-- 可等待线程倍数，默认为5.例如connectionsPerHost最大允许10个连接，则10*5=50个线程可以等待，更多的线程将直接抛异常 -->
    <property name="threadsAllowedToBlockForConnectionMultiplier" value="5" />
    <!-- socket读写时超时时间(毫秒)，默认为0，不超时 -->
    <property name="socketTimeout" value="0" />
    <!-- 是socket连接在防火墙上保持活动的特性，默认为false -->
    <property name="socketKeepAlive" value="false" />
    <!-- 对应全局的WriteConcern.SAFE，默认为false -->
    <property name="safe" value="true" />
    <!-- 对应全局的WriteConcern中的w，默认为0 -->
    <property name="w" value="0" />
    <!-- 对应全局的WriteConcern中的wtimeout，默认为0 -->
    <property name="wtimeout" value="0" />
    <!-- 对应全局的WriteConcern.FSYNC_SAFE，如果为真，每次写入要等待写入磁盘，默认为false -->
    <property name="fsync" value="false" />
    <!-- 对应全局的WriteConcern.JOURNAL_SAFE，如果为真，每次写入要等待日志文件写入磁盘，默认为false -->
    <property name="j" value="false" />
  </bean>

  <!-- 使用工厂创建mongo实例 -->
  <bean id="mongo" class="com.wondersgroup.bigdata.project.morphia.config.MongoFactoryBean">
    <!-- mongoDB的配置对象 -->
    <property name="mongoOptions" ref="mongoOptions"/>
    <!-- 是否主从分离(读取从库)，默认为false，读写都在主库 -->
    <property name="readSecondary" value="false"/>

    <!-- 设定写策略，默认为WriteConcern.SAFE，优先级高于mongoOptions中的safe -->
    <property name="writeConcern" value="SAFE"/>

    <!-- 设定服务器列表，默认为localhost:27017 -->
    <property name="serverStrings">
      <array>
        <value>localhost:27017</value>
      </array>
    </property>
  </bean>

<!--   使用工厂创建morphia实例，同时完成类映射操作-->
  <bean id="morphia" class="com.wondersgroup.bigdata.project.morphia.config.MorphiaFactoryBean" >
    <!-- 指定要扫描的POJO包路径 -->
    <property name="mapPackages">
      <array>
        <value>com.wondersgroup.bigdata.project.morphia.domain</value>
      </array>
    </property>
  </bean>

<!--   使用工厂创建datastore，同时完成index和caps的确认操作-->
<!--  <bean id="datastore_not_use" class="com.wondersgroup.bigdata.project.morphia.config.DatastoreFactoryBean" >-->
<!--    <property name="morphia" ref="morphia"/>-->
<!--    <property name="mongo" ref="mongo"/>-->

<!--    &lt;!&ndash; collection的名称 &ndash;&gt;-->
<!--    <property name="dbName" value="files"/>-->
<!--    &lt;!&ndash; 用户名和密码可以为空 &ndash;&gt;-->
<!--    <property name="username" value="taizhou"/>-->
<!--    <property name="password" value="123456"/>-->

<!--    &lt;!&ndash; 是否进行index和caps的确认操作，默认为flase &ndash;&gt;-->
<!--    <property name="toEnsureIndexes" value="true"/>-->
<!--    <property name="toEnsureCaps" value="true"/>-->
<!--  </bean>-->
  <!-- ****************************************** 配置 MongoDB - End ****************************************** -->

```