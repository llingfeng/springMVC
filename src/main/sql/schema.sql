create database goods CHARACTER set utf8;

-- 商品类别表(goods_category)
create table goods_category(
  goods_category_id int(11) NOT NULL auto_increment comment '商品类别ID',
  goods_category_name VARCHAR (90) not NULL comment '商品类别名称',
  create_time datetime not null comment '商品类别创建时间',
  update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '商品类别更新时间',
  PRIMARY KEY (goods_category_id)
)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='商品类别表';

ALTER TABLE goods_category MODIFY create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品类别创建时间';

show create TABLE  goods_category;

ALTER TABLE goods_category ADD create_person VARCHAR(30) NOT NULL COMMENT '创建人';

ALTER table goods_category drop create_person;

INSERT INTO goods_category (goods_category_name, create_person) VALUES ('手机3','jack');
INSERT INTO goods_category (goods_category_name, create_person) VALUES ('电脑3','mark');
INSERT INTO goods_category (goods_category_name, create_person) VALUES ('汽车3','json');
INSERT INTO goods_category (goods_category_name, create_person) VALUES ('鼠标3','sky');

-- 商品详情表(goods)
create TABLE goods(
  goods_id int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  goods_name VARCHAR(90) NOT NULL COMMENT '商品名字',
  goods_number int(11) NOT NULL COMMENT '商品库存',
  goods_price FLOAT not NULL COMMENT '商品价格',
  goods_category_id int(11) NOT NULL COMMENT '商品类别',
  create_time DATETIME NOT NULL DEFAULT current_timestamp COMMENT '商品创建时间',
  update_time TIMESTAMP not NULL DEFAULT current_timestamp COMMENT '商品更新时间',
  PRIMARY KEY (goods_id)
)ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '商品详情表';

ALTER TABLE goods ADD create_person VARCHAR(30) NOT NULL ;

INSERT INTO goods(goods_name, goods_number, goods_price, goods_category_id,create_person)
VALUES ('诺基亚',100,1299,1,'ansen');
INSERT INTO goods(goods_name, goods_number, goods_price, goods_category_id,create_person)
VALUES ('小米',200,1599,1,'雷军');
INSERT INTO goods(goods_name, goods_number, goods_price, goods_category_id,create_person)
VALUES ('大众',10,129900,3,'大众');
INSERT INTO goods(goods_name, goods_number, goods_price, goods_category_id,create_person)
VALUES ('联想',90,4999,2,'小明');
INSERT INTO goods(goods_name, goods_number, goods_price, goods_category_id,create_person)
VALUES ('华硕',45,3999,2,'小华');
INSERT INTO goods(goods_name, goods_number, goods_price, goods_category_id,create_person)
VALUES ('态度鼠标',100,299,4,'sky');
