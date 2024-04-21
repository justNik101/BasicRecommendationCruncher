delete from skill;
insert into skill(id,skill_group,parent_skill_group_id) values(1,"RootSkill", 1);
insert into skill(id,skill_group,parent_skill_group_id) values(2,"Tech", 1);
insert into skill(id,skill_group,parent_skill_group_id) values(3,"NonTech", 1);
insert into skill(id,skill_group,parent_skill_group_id) values(4,"Java", 2);
insert into skill(id,skill_group,parent_skill_group_id) values(5,"Python", 2);
insert into skill(id,skill_group,parent_skill_group_id) values(6,"Business Development", 3);
insert into skill(id,skill_group,parent_skill_group_id) values(7,"Marketing", 3);
insert into skill(id,skill_group,parent_skill_group_id) values(8,"Sales", 3);


delete from user;
insert into user(id,email_id,company_name,total_years_of_experience,skill_id) values(1,"testemail1@gmail.com","XYZOrg1",4,4);
insert into user(id,email_id,company_name,total_years_of_experience,skill_id) values(2,"testemail2@gmail.com","XYZOrg1",4,4);
insert into user(id,email_id,company_name,total_years_of_experience,skill_id) values(3,"testemail3@gmail.com","XYZOrg1",4,5);
insert into user(id,email_id,company_name,total_years_of_experience,skill_id) values(4,"testemail4@gmail.com","XYZOrg1",4,6);
insert into user(id,email_id,company_name,total_years_of_experience,skill_id) values(5,"testemail5@gmail.com","XYZOrg1",4,7);


delete from recommendation;

insert into recommendation(id,sender_uid,receiver_uid,score) values(1,2,1,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(2,3,1,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(3,4,1,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(4,5,1,4);

insert into recommendation(id,sender_uid,receiver_uid,score) values(5,1,2,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(6,3,2,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(7,4,2,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(8,5,2,4);

insert into recommendation(id,sender_uid,receiver_uid,score) values(9,1,3,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(10,2,3,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(11,4,3,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(12,5,3,4);

insert into recommendation(id,sender_uid,receiver_uid,score) values(13,1,4,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(14,2,4,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(15,3,4,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(16,5,4,4);

insert into recommendation(id,sender_uid,receiver_uid,score) values(17,1,5,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(18,2,5,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(19,3,5,4);
insert into recommendation(id,sender_uid,receiver_uid,score) values(20,4,5,4);
