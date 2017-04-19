SET search_path TO "itsm2";

--插入区域数据
truncate table District_Info;
insert into District_Info values(1,'AA');
insert into District_Info values(2,'BB');
insert into District_Info values(3,'CC');

--插入服务商数据
truncate table Sup_Project_Group;

--插入区域与服务商数据
truncate table District_Group_Map;

--插入服务站数据
truncate table Service_Desk;

--插入工程师数据
truncate table Emplee_Info;
 
--插入餐厅数据
truncate table Dining_Room;
insert into Dining_Room values(1,'YUMC01',1); 
insert into Dining_Room values(2,'YUMC02',1); 
insert into Dining_Room values(3,'YUMC03',2); 
insert into Dining_Room values(4,'YUMC04',2); 
insert into Dining_Room values(5,'YUMC05',3); 
insert into Dining_Room values(6,'YUMC06',3); 

--插入餐厅与服务站数据
truncate table Dining_Desk_Map;

truncate table sys_params;
insert into sys_params values('response','40','响应时间(单位分钟)');

truncate table sla_config;
insert into sla_config values(0,1,4,'7*16(7:00~23:00)','');
insert into sla_config values(0,2,8,'7*16(7:00~23:00)','');
insert into sla_config values(0,3,12,'7*16(7:00~23:00)','');
insert into sla_config values(0,4,24,'7*16(7:00~23:00)','');
insert into sla_config values(1,1,8,'7*16(7:00~23:00)','');
insert into sla_config values(1,2,12,'7*16(7:00~23:00)','');
insert into sla_config values(1,3,18,'7*16(7:00~23:00)','');
insert into sla_config values(1,4,32,'7*16(7:00~23:00)','');
insert into sla_config values(2,1,22,'7*16(7:00~23:00)','');
insert into sla_config values(2,2,24,'7*16(7:00~23:00)','');
insert into sla_config values(2,3,36,'7*16(7:00~23:00)','');
insert into sla_config values(2,4,48,'7*16(7:00~23:00)','');
insert into sla_config values(3,1,480,'不去除非工作时间','');
insert into sla_config values(3,2,480,'不去除非工作时间','');
insert into sla_config values(3,3,480,'不去除非工作时间','');
insert into sla_config values(3,4,480,'不去除非工作时间','');

truncate table Desk_Robot_Map;
insert into Desk_Robot_Map values(1,'服务站A','b4cd5708aea1d49b2105fd8400d19fba3de49adf268c2db0a49fb1a0c4863fc1','dace7d35c614443d34930dd3b4930c808007744472994167a1bfa69b6633dca8','');
insert into Desk_Robot_Map values(2,'服务站B','5d28cfaa263730ca953571b559c670ce7dbe8e556a67122be5767c84b858fa06','dbd32313842c1d4190ecd536a7d71779fde40aec42ba919192aa19a0efed0809','');
insert into Desk_Robot_Map values(3,'服务站C','b0497176c968f4ce78a703ab054370d1f1417ad6bc78e8ee4abf6f66628c7bf0','8678768e233f2b74a477c9d49306c96c37c51aed9f7236ff57adfd0948191119','');
insert into Desk_Robot_Map values(4,'服务站D','da14f38aebd568424780303af3fd1adb6fab4416ce0b2c88b56b16e2395ea276','de9aaccee0c3c3a019561b028783e1cb4f77fecd80e8f727c603d8ea78accadb','');
