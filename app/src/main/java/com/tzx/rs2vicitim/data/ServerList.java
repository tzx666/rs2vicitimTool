package com.tzx.rs2vicitim.data;

import java.util.List;

public class ServerList {
    private List<Servers> data;
    public static class Servers{
        private String type;
        private String id;
        private Server_Attributes attributes;
        public static class Server_Attributes{
            private String id;
            private String name;
            private String address;
            private String ip;
            private String port;
            private String players;
            private String maxPlayers;
            private String rank;
            private List<String>location;
            private String status;
            private Server_Detail details;
            public static class Server_Detail{
                private String rs2v_MapGame;
                private String rs2v_bIsCampaignGame;
                private String rs2v_bRequiresPassword;
                private String rs2v_bUsesStats;
                private String rs2v_AdminContact;
                private String rs2v_bIsRanked;
                private String rs2v_SpectatorMode;
                private String rs2v_FriendlyFire;
                private String rs2v_MutatorsRunning;
                private String rs2v_MapType;
                private String rs2v_bIsDedicated;
                private String serverSteamId;
                private String map;
                private String rs2v_bAntiCheatProtected;
                private String rs2v_MaxHonor;
                private String rs2v_MinHonor;
                private String rs2v_GameMode;
                private String rs2v_RealismLevel;

                public String getMap() {
                    return map;
                }

                public String getRs2v_AdminContact() {
                    return rs2v_AdminContact;
                }

                public String getRs2v_bAntiCheatProtected() {
                    return rs2v_bAntiCheatProtected;
                }

                public String getRs2v_bIsCampaignGame() {
                    return rs2v_bIsCampaignGame;
                }

                public String getRs2v_bIsDedicated() {
                    return rs2v_bIsDedicated;
                }

                public String getRs2v_bIsRanked() {
                    return rs2v_bIsRanked;
                }

                public String getRs2v_bRequiresPassword() {
                    return rs2v_bRequiresPassword;
                }

                public String getRs2v_bUsesStats() {
                    return rs2v_bUsesStats;
                }

                public String getRs2v_FriendlyFire() {
                    return rs2v_FriendlyFire;
                }

                public String getRs2v_GameMode() {
                    return rs2v_GameMode;
                }

                public String getRs2v_MapGame() {
                    return rs2v_MapGame;
                }

                public String getRs2v_MapType() {
                    return rs2v_MapType;
                }

                public String getRs2v_MaxHonor() {
                    return rs2v_MaxHonor;
                }

                public String getRs2v_MinHonor() {
                    return rs2v_MinHonor;
                }

                public String getRs2v_MutatorsRunning() {
                    return rs2v_MutatorsRunning;
                }

                public String getRs2v_RealismLevel() {
                    return rs2v_RealismLevel;
                }

                public String getRs2v_SpectatorMode() {
                    return rs2v_SpectatorMode;
                }

                public String getServerSteamId() {
                    return serverSteamId;
                }

                public void setMap(String map) {
                    this.map = map;
                }

                public void setRs2v_AdminContact(String rs2v_AdminContact) {
                    this.rs2v_AdminContact = rs2v_AdminContact;
                }

                public void setRs2v_bAntiCheatProtected(String rs2v_bAntiCheatProtected) {
                    this.rs2v_bAntiCheatProtected = rs2v_bAntiCheatProtected;
                }

                public void setRs2v_bIsCampaignGame(String rs2v_bIsCampaignGame) {
                    this.rs2v_bIsCampaignGame = rs2v_bIsCampaignGame;
                }

                public void setRs2v_bIsDedicated(String rs2v_bIsDedicated) {
                    this.rs2v_bIsDedicated = rs2v_bIsDedicated;
                }

                public void setRs2v_bIsRanked(String rs2v_bIsRanked) {
                    this.rs2v_bIsRanked = rs2v_bIsRanked;
                }

                public void setRs2v_bRequiresPassword(String rs2v_bRequiresPassword) {
                    this.rs2v_bRequiresPassword = rs2v_bRequiresPassword;
                }

                public void setRs2v_bUsesStats(String rs2v_bUsesStats) {
                    this.rs2v_bUsesStats = rs2v_bUsesStats;
                }

                public void setRs2v_FriendlyFire(String rs2v_FriendlyFire) {
                    this.rs2v_FriendlyFire = rs2v_FriendlyFire;
                }

                public void setRs2v_GameMode(String rs2v_GameMode) {
                    this.rs2v_GameMode = rs2v_GameMode;
                }

                public void setRs2v_MapGame(String rs2v_MapGame) {
                    this.rs2v_MapGame = rs2v_MapGame;
                }

                public void setRs2v_MapType(String rs2v_MapType) {
                    this.rs2v_MapType = rs2v_MapType;
                }

                public void setRs2v_MaxHonor(String rs2v_MaxHonor) {
                    this.rs2v_MaxHonor = rs2v_MaxHonor;
                }

                public void setRs2v_MinHonor(String rs2v_MinHonor) {
                    this.rs2v_MinHonor = rs2v_MinHonor;
                }

                public void setRs2v_MutatorsRunning(String rs2v_MutatorsRunning) {
                    this.rs2v_MutatorsRunning = rs2v_MutatorsRunning;
                }

                public void setRs2v_RealismLevel(String rs2v_RealismLevel) {
                    this.rs2v_RealismLevel = rs2v_RealismLevel;
                }

                public void setRs2v_SpectatorMode(String rs2v_SpectatorMode) {
                    this.rs2v_SpectatorMode = rs2v_SpectatorMode;
                }

                public void setServerSteamId(String serverSteamId) {
                    this.serverSteamId = serverSteamId;
                }
            }
            private String createdAt;
            private String updatedAt;
            private String portQuery;
            private String country;

            public void setId(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public List<String> getLocation() {
                return location;
            }

            public Server_Detail getDetails() {
                return details;
            }

            public String getAddress() {
                return address;
            }

            public String getCountry() {
                return country;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public String getIp() {
                return ip;
            }

            public String getMaxPlayers() {
                return maxPlayers;
            }

            public String getName() {
                return name;
            }

            public String getPlayers() {
                return players;
            }

            public String getPort() {
                return port;
            }

            public String getPortQuery() {
                return portQuery;
            }

            public String getRank() {
                return rank;
            }

            public String getStatus() {
                return status;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public void setDetails(Server_Detail details) {
                this.details = details;
            }

            public void setIp(String ip) {
                this.ip = ip;
            }

            public void setLocation(List<String> location) {
                this.location = location;
            }

            public void setMaxPlayers(String maxPlayers) {
                this.maxPlayers = maxPlayers;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPlayers(String players) {
                this.players = players;
            }

            public void setPort(String port) {
                this.port = port;
            }

            public void setPortQuery(String portQuery) {
                this.portQuery = portQuery;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
        private Server_relationships relationships;
        public static class Server_relationships{
            private Game game;
            public static class Game{
                private ServerName data;
                public static class ServerName{
                    private String type;
                    private String id;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getType() {
                        return type;
                    }
                }

                public ServerName getData() {
                    return data;
                }

                public void setData(ServerName data) {
                    this.data = data;
                }
            }

            public Game getGame() {
                return game;
            }

            public void setGame(Game game) {
                this.game = game;
            }
        }

        public Server_Attributes getAttributes() {
            return attributes;
        }

        public Server_relationships getRelationships() {
            return relationships;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public void setAttributes(Server_Attributes attributes) {
            this.attributes = attributes;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setRelationships(Server_relationships relationships) {
            this.relationships = relationships;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public void setData(List<Servers> data) {
        this.data = data;
    }

    public List<Servers> getData() {
        return data;
    }
}
