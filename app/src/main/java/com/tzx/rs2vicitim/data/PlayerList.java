package com.tzx.rs2vicitim.data;

import java.io.Serializable;
import java.util.List;

public class PlayerList implements Serializable {
    private List<Player> data;
    private link links;
    public static class link implements Serializable{
        private String next;

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }
    public static class Player implements Serializable{
        private String type;
        private String id;
        private attr attributes;
        public static class attr implements Serializable{
            private String id;
            private String name;
            private String createdAt;
            private String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public String getName() {
                return name;
            }

            public String getCreatedAt() {
                return createdAt;
            }
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setAttributes(attr attributes) {
            this.attributes = attributes;
        }

        public attr getAttributes() {
            return attributes;
        }
    }
    private List<String> included;

    public void setData(List<Player> data) {
        this.data = data;
    }

    public List<Player> getData() {
        return data;
    }

    public link getLinks() {
        return links;
    }

    public List<String> getIncluded() {
        return included;
    }

    public void setIncluded(List<String> included) {
        this.included = included;
    }

    public void setLinks(link links) {
        this.links = links;
    }
}
