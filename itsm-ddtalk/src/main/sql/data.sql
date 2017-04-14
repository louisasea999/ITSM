SET search_path TO "itsm2";

--插入区域数据
truncate table District_Info;
insert into District_Info values(1,'世纪公园区域');
insert into District_Info values(2,'陆家嘴区域');

--插入服务商数据
truncate table Sup_Project_Group;
insert into Sup_Project_Group values(1,'甲服务商项目组','');
insert into Sup_Project_Group values(2,'乙服务商项目组','');

--插入区域与服务商数据
truncate table District_Group_Map;
insert into District_Group_Map values(1,1,1,''); --世纪公园+甲服务商
insert into District_Group_Map values(2,1,2,''); --世纪公园+乙服务商
insert into District_Group_Map values(3,2,1,''); --陆家嘴+甲服务商
insert into District_Group_Map values(4,2,2,''); --陆家嘴+乙服务商
select setval('district_group_map_district_group_id_seq', 10);

--插入服务站数据
truncate table Service_Desk;
insert into Service_Desk values(1,'服务站A',1,''); 
insert into Service_Desk values(2,'服务站B',1,''); 
insert into Service_Desk values(3,'服务站C',2,''); 
insert into Service_Desk values(4,'服务站D',2,''); 

--插入工程师数据
truncate table Emplee_Info;
insert into Emplee_Info values(1,'工程师a1',1,''); 
insert into Emplee_Info values(2,'工程师a2',1,''); 
insert into Emplee_Info values(3,'工程师a3',1,''); 
insert into Emplee_Info values(4,'工程师b1',2,''); 
insert into Emplee_Info values(5,'工程师b2',2,''); 
insert into Emplee_Info values(6,'工程师c1',3,''); 
insert into Emplee_Info values(7,'工程师c2',3,''); 
insert into Emplee_Info values(8,'工程师c3',3,''); 
insert into Emplee_Info values(9,'工程师d1',4,''); 
insert into Emplee_Info values(10,'工程师d2',4,''); 
 
--插入餐厅数据
truncate table Dining_Room;
insert into Dining_Room values(1,'星巴克世纪公园店',1); 
insert into Dining_Room values(2,'肯德基陆家嘴店',2); 

--插入餐厅与服务站数据
truncate table Dining_Desk_Map;
insert into Dining_Desk_Map values(1,1,1,''); --星巴克世纪公园-服务站A
insert into Dining_Desk_Map values(2,2,3,''); --肯德基陆家嘴店-服务站C
select setval('dining_desk_map_dining_desk_id_seq', 10);
