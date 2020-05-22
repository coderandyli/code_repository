package com.coderandyli.designpattern.chapter_06.section_46.case_01;

import org.apache.commons.lang3.StringUtils;

/**
 * 建造者模式
 */
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    @Override
    public String toString() {
        return "ResourcePoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }


    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 0;
        private static final int DEFAULT_MAX_IDLE = 0;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public Builder() {
        }

        public ResourcePoolConfig build() {
            if (minIdle > maxIdle) {
                throw new IllegalArgumentException("maxIdle should not less than maxIdle");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("maxTotal should not less than zero");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not less than zero");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should not less than zero");
            }
            this.minIdle = minIdle;
            return this;
        }
    }
}
