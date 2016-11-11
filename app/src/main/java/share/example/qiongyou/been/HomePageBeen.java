package share.example.qiongyou.been;

import java.util.List;

public class HomePageBeen {
    private int status;
    private String info;
    private int times;
    private DataBean data;
    private ExtraBean extra;
    private String ra_referer;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public ExtraBean getExtra() {
        return extra;
    }

    public void setExtra(ExtraBean extra) {
        this.extra = extra;
    }

    public String getRa_referer() {
        return ra_referer;
    }

    public void setRa_referer(String ra_referer) {
        this.ra_referer = ra_referer;
    }

    public static class DataBean {
        private String keyword;
        /**
         * title : 点评我去过的目的地, 帮助更多穷游er
         * url : http://m.qyer.com/place/comment.php/?action=inviteComment&from_device=app
         * icon_url : http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684809807092
         * need_login : 1
         * page_title : 等你点评的目的地
         * target : 1
         */

        private CommentEntryBean comment_entry;
        /**
         * total : 776
         * page : 1
         * entry : [{"id":866,"type":1,"column":"穷游活动","title":"今日话题 | 剁手节你败了什么？","url":"http://bbs.qyer.com/thread-2633491-1.html","cover":"http://pic.qyer.com/public/2016/11/11/58256da07f231.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{},"subject":"这个双11，折扣机票、美衣新鞋还是手机平板？你都入手了哪些好物，进来一起忏悔一番吧！","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684648561912","up":0},{"id":846,"type":1,"column":"精华游记","title":"希腊旅行结婚记，这狗粮我吃了","url":"http://bbs.qyer.com/thread-1397170-1.html","cover":"http://pic.qyer.com/public/2016/11/09/5822cb0a86f87.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{"username":"毛哥家的金小姐","pic":"http://pic1.qyer.com/avatar/000/02/81/72/index/200?v=1452367451"},"subject":"你带着我行走天涯，我许诺你一世情意。","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684649345955","up":0},{"id":858,"type":1,"column":"发现目的地","title":"丹麦被忽略的绝美天堂","url":"http://place.qyer.com/mguide/6932/","cover":"http://pic.qyer.com/public/2016/11/11/582530fa416c7.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{},"subject":"如果你知道这些地方，你会愿意在丹麦一直待下去。","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684649575758","up":0},{"id":852,"type":1,"column":"世界那么大","title":"日本那些令人震惊的极致精神","url":"http://m.qyer.com/place/guide/zt/page/GvcQvq80TAQ/?lk=1","cover":"http://pic.qyer.com/public/2016/11/09/58229da3535bd.png?imageView2/1/w/800/h/450/format/webp/710x360","author":{},"subject":"贩卖机还有不同口音？佩服佩服。","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684649752474","up":0},{"id":845,"type":1,"column":"精华游记","title":"在冰河裸泳是怎样的体验？","url":"http://bbs.qyer.com/thread-2624367-1.html","cover":"http://pic.qyer.com/public/2016/11/09/5822c3ba15a54.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{"username":"白宇","pic":"http://pic4.qyer.com/avatar/001/41/43/11/index/200?v=1444882992"},"subject":"当我跳进冰河之中，全身每一处皮肤的神经末梢，都只能感受一种体验叫\u2014\u2014\u201c寒冷\u201d。","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684649972983","up":0},{"id":843,"type":1,"column":"穷游放映室","title":"旅行代购，一辈子不能说的伤\u2026\u2026","url":"http://bbs.qyer.com/thread-2578968-1.html","cover":"http://pic.qyer.com/public/2016/11/09/5822bbe6c9d0e.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{},"subject":"曾经出国旅行恨不得刷屏嘚瑟，如今有一部分人出国旅行生怕暴露行踪，WHY？","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684650182352","up":0},{"id":844,"type":1,"column":"精华游记","title":"如何用单反自拍美图？这里有答案","url":"http://bbs.qyer.com/thread-2616945-1.html","cover":"http://pic.qyer.com/public/2016/11/09/5822bf657dc89.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{"username":"sakuraheqian","pic":"http://pic2.qyer.com/avatar/001/66/93/02/1459751574/index/200?v=1459751574"},"subject":"第一次全程自己给自己拍照，我发现了单反自拍的这些秘密\u2026\u2026","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684650358677","up":0},{"id":850,"type":1,"column":"发现目的地","title":"光棍节前，带她去这些地方吻下她","url":"http://bbs.qyer.com/thread-1392301-1.html","cover":"http://pic.qyer.com/public/2016/11/09/5822d661064d5.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{},"subject":"抛开烦恼，让我们一起寻访全球最让人心潮澎湃的完美接吻地，伴随美景与浪漫的吻，一定能马上脱单！","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684650609698","up":0},{"id":842,"type":1,"column":"精华游记","title":"省钱攻略：教你6800元品质游日本","url":"http://bbs.qyer.com/thread-2614285-1.html","cover":"http://pic.qyer.com/public/2016/11/09/5822bb3cc920c.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{"username":"爱爱范儿","pic":"http://pic3.qyer.com/avatar/001/14/33/89/1474776233/index/200?v=1474776233"},"subject":"谁说第一次去日本一定要去京阪奈？或许你应该飞往九州岛，尝一碗浓郁的福冈拉面、泡一泡南小国温泉乡、看一眼逗逼的熊本部长\u2026\u2026","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684650816505","up":0},{"id":853,"type":1,"column":"最世界自由行","title":"战役即将打响，明天最后一天，你准备好了么？","url":"http://z.qyer.com/zt/20161111/?source=app","cover":"http://pic.qyer.com/public/2016/11/09/5822e8647c739.jpg?imageView2/1/w/800/h/450/format/webp/710x360","author":{},"subject":"虽然说起来有点俗套，不过旅行者的双十一，错过真的还要再等一年。","subitems":[],"icon_url":"http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684650967892","up":0}]
         */

        private FeedBean feed;

        private List<SlideBean> slide;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public CommentEntryBean getComment_entry() {
            return comment_entry;
        }

        public void setComment_entry(CommentEntryBean comment_entry) {
            this.comment_entry = comment_entry;
        }

        public FeedBean getFeed() {
            return feed;
        }

        public void setFeed(FeedBean feed) {
            this.feed = feed;
        }

        public List<SlideBean> getSlide() {
            return slide;
        }

        public void setSlide(List<SlideBean> slide) {
            this.slide = slide;
        }

        public static class CommentEntryBean {
            private String title;
            private String url;
            private String icon_url;
            private int need_login;
            private String page_title;
            private int target;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public int getNeed_login() {
                return need_login;
            }

            public void setNeed_login(int need_login) {
                this.need_login = need_login;
            }

            public String getPage_title() {
                return page_title;
            }

            public void setPage_title(String page_title) {
                this.page_title = page_title;
            }

            public int getTarget() {
                return target;
            }

            public void setTarget(int target) {
                this.target = target;
            }
        }

        public static class FeedBean {
            private int total;
            private int page;
            /**
             * id : 866
             * type : 1
             * column : 穷游活动
             * title : 今日话题 | 剁手节你败了什么？
             * url : http://bbs.qyer.com/thread-2633491-1.html
             * cover : http://pic.qyer.com/public/2016/11/11/58256da07f231.jpg?imageView2/1/w/800/h/450/format/webp/710x360
             * author : {}
             * subject : 这个双11，折扣机票、美衣新鞋还是手机平板？你都入手了哪些好物，进来一起忏悔一番吧！
             * subitems : []
             * icon_url : http://pic.qyer.com/public/place/iconconfig/2016/07/14/14684648561912
             * up : 0
             */

            private List<EntryBean> entry;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public List<EntryBean> getEntry() {
                return entry;
            }

            public void setEntry(List<EntryBean> entry) {
                this.entry = entry;
            }

            public static class EntryBean {
                private int id;
                private int type;
                private String column;
                private String title;
                private String url;
                private String cover;
                private String subject;
                private String icon_url;
                private int up;
                private List<?> subitems;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getColumn() {
                    return column;
                }

                public void setColumn(String column) {
                    this.column = column;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getSubject() {
                    return subject;
                }

                public void setSubject(String subject) {
                    this.subject = subject;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public int getUp() {
                    return up;
                }

                public void setUp(int up) {
                    this.up = up;
                }

                public List<?> getSubitems() {
                    return subitems;
                }

                public void setSubitems(List<?> subitems) {
                    this.subitems = subitems;
                }
            }
        }

        public static class SlideBean {
            private String url;
            private String photo;
            private int is_ads;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public int getIs_ads() {
                return is_ads;
            }

            public void setIs_ads(int is_ads) {
                this.is_ads = is_ads;
            }
        }
    }

    public static class ExtraBean {
        private int ra_switch;

        public int getRa_switch() {
            return ra_switch;
        }

        public void setRa_switch(int ra_switch) {
            this.ra_switch = ra_switch;
        }
    }
}
