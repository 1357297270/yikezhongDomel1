package com.example.administrator.yikezhongdomel.fragment.video.model;

import java.util.List;

/**
 * data;2018/7/10
 * author:任志军
 */

public class VideoBean {
    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/153084981094520180706120330.png","createTime":"2018-07-06T12:03:30","favoriteNum":1,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":1,"uid":11196,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1527577493751touxiang.jpg","nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530849810945video_20180706_120317.mp4","wid":574,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/153084822157020180706113653.png","createTime":"2018-07-06T11:37:01","favoriteNum":1,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":0,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530848221570VID20180706113645.mp4","wid":573,"workDesc":""},{"commentNum":1,"comments":[{"cid":712,"content":"爱是当你轰隆隆路名牌\n","createTime":"2018-07-09T19:42:41","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":13599,"wid":572}],"cover":"https://www.zhaoapi.cn/images/quarter/153084822042920180706113653.png","createTime":"2018-07-06T11:37:00","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":0,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530848220429VID20180706113645.mp4","wid":572,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/153084797294520180706113236.png","createTime":"2018-07-06T11:32:52","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":0,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530847972945VID20180706113225.mp4","wid":571,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/153084682117920180706111331.png","createTime":"2018-07-06T11:13:41","favoriteNum":1,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":1,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530846821179video_20180706_111310.mp4","wid":570,"workDesc":""},{"commentNum":1,"comments":[{"cid":706,"content":"你上班把健康","createTime":"2018-07-09T12:10:15","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":13599,"wid":569}],"cover":"https://www.zhaoapi.cn/images/quarter/153084610574220180706110144.png","createTime":"2018-07-06T11:01:45","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":1,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530846105742video_20180706_110137.mp4","wid":569,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/153079496794520180705204918.png","createTime":"2018-07-05T20:49:27","favoriteNum":2,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":1,"praiseNum":2,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530794967945video_20180705_204911.mp4","wid":568,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/153079333305420180705202211.png","createTime":"2018-07-05T20:22:13","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":0,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530793333054video_20180705_202203.mp4","wid":567,"workDesc":""},{"commentNum":1,"comments":[{"cid":10,"content":"1","createTime":"2017-12-01T10:27:35","jid":null,"mvp":null,"nickname":"_zhang","praiseNum":0,"uid":551,"wid":566}],"cover":"https://www.zhaoapi.cn/images/quarter/153032406157020180630100050.png","createTime":"2018-06-30T10:01:01","favoriteNum":1,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":0,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530324061570video_20180630_100031.mp4","wid":566,"workDesc":""},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/153032379142920180630095628.png","createTime":"2018-06-30T09:56:31","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":0,"uid":10234,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1530323791429video_20180630_095618.mp4","wid":565,"workDesc":""}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/153084981094520180706120330.png
         * createTime : 2018-07-06T12:03:30
         * favoriteNum : 1
         * latitude : 0.0
         * localUri : null
         * longitude : 0.0
         * playNum : 0
         * praiseNum : 1
         * uid : 11196
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1527577493751touxiang.jpg","nickname":null,"praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1530849810945video_20180706_120317.mp4
         * wid : 574
         * workDesc :
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<?> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1527577493751touxiang.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
