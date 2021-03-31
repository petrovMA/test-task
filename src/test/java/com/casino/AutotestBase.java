package com.casino;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public abstract class AutotestBase {

    protected Config config;

    public AutotestBase() {
        config = ConfigFactory.parseFile(new File("autotests.conf"));
    }
}
