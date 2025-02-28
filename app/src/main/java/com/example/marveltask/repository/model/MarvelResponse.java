package com.example.marveltask.repository.model;

import java.util.List;

public class MarvelResponse {
    private DataContainer data;

    public DataContainer getData() {
        return data;
    }

    public void setData(DataContainer data) {
        this.data = data;
    }

    public static class DataContainer {
        private int offset;
        private int limit;
        private int total;
        private int count;
        private List<Character> results;

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Character> getResults() {
            return results;
        }

        public void setResults(List<Character> results) {
            this.results = results;
        }
    }
}

