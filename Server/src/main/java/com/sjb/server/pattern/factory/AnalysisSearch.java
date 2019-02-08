package com.sjb.server.pattern.factory;

/**
 * ConcreteProduct(구체적인 제품)
 */
public class AnalysisSearch extends Product {
    // 다형성 사용
    @Override
    protected void run() {
        String result = analysisDatabase.get("test");
    }
}
