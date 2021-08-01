CREATE TABLE zsp_test.user (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  name varchar(100) NOT NULL COMMENT '用户名',
  password varchar(100) NOT NULL COMMENT '密码',
  status bit(1) NOT NULL DEFAULT b'1' COMMENT '状态，1可用，0删除',
  creator varchar(50) DEFAULT NULL COMMENT '创建人',
  create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  modifier varchar(50) DEFAULT NULL COMMENT '修改人',
  modify_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


CREATE TABLE zsp_test.goods (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  goods_code varchar(100) NOT NULL COMMENT '货号',
  sale_amount decimal(12,2) NOT NULL COMMENT '售价',
  user_id int(11) NOT NULL COMMENT '用户ID',
  status bit(1) NOT NULL DEFAULT b'1' COMMENT '状态，1可用，0删除',
  creator varchar(50) DEFAULT NULL COMMENT '创建人',
  create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  modifier varchar(50) DEFAULT NULL COMMENT '修改人',
  modify_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_goods_code` (`goods_code`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='商品表';


CREATE TABLE zsp_test.order (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  order_code varchar(100) NOT NULL COMMENT '订单号',
  goods_code varchar(100) NOT NULL COMMENT '货号',
  sale_amount decimal(12,2) NOT NULL COMMENT '售价',
  num int(11) NOT NULL COMMENT '数量',
  total_amount decimal(12,2) NOT NULL COMMENT '总价',
  user_id int(11) NOT NULL COMMENT '用户ID',
  status bit(1) NOT NULL DEFAULT b'1' COMMENT '状态，1可用，0删除',
  creator varchar(50) DEFAULT NULL COMMENT '创建人',
  create_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  modifier varchar(50) DEFAULT NULL COMMENT '修改人',
  modify_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_order_code` (`order_code`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';