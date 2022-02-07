package com.dlink.executor;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * LocalStreamExecuter
 *
 * @author wenmo
 * @since 2021/5/25 13:48
 **/
public class LocalStreamExecutor extends AbstractStreamExecutor {

    public LocalStreamExecutor(ExecutorSetting executorSetting) {
        this.executorSetting = executorSetting;
        this.environment = StreamExecutionEnvironment.createLocalEnvironment();
        init();
    }

    @Override
    CustomTableEnvironment createCustomTableEnvironment() {
        return CustomTableEnvironmentImpl.create(environment);
    }
}
