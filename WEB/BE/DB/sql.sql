INSERT INTO user (user_id, user_pwd, name, email_id, email_domain, phone, birth, gender) 
VALUES ('ssafy', '1234', '김싸피', 'ssafy', 'ssafy.com', '010-0000-0000', '1996-9-10', 'M');
INSERT INTO user (user_id, user_pwd, name, email_id, email_domain, phone, birth, gender) 
VALUES ('ssafy2', '1234', '이싸피', 'ssafylee', 'ssafy.com', '010-0000-1111', '1997-9-10', 'M');
INSERT INTO user (user_id, user_pwd, name, email_id, email_domain, phone, birth, gender) 
VALUES ('ssafy3', '1234', '박싸피', 'ssafypark', 'ssafy.com', '010-0000-1112', '1996-10-10', 'M');
INSERT INTO user (user_id, user_pwd, name, email_id, email_domain, phone, birth, gender) 
VALUES ('ssafy4', '1234', '최싸피', 'ssafychoi', 'ssafy.com', '010-0000-1113', '1999-3-11', 'M');
INSERT INTO user (user_id, user_pwd, name, email_id, email_domain, phone, birth, gender, is_admin) 
VALUES ('admin', 'admin', '김관리', 'admin', 'ssafy.com', '010-1111-1111', '1990-12-24', 'M', true);
-----------------------------------------------------------------------
INSERT INTO company (company_name) VALUES ('동원');
INSERT INTO company (company_name) VALUES ('풀무원');
INSERT INTO company (company_name) VALUES ('청정원');
INSERT INTO company (company_name) VALUES ('CJ');
INSERT INTO company (company_name) VALUES ('하림');
INSERT INTO company (company_name) VALUES ('서울우유');
INSERT INTO company (company_name) VALUES ('태성식품');
INSERT INTO company (company_name) VALUES ('롯데');
INSERT INTO company (company_name) VALUES ('삼립');
INSERT INTO company (company_name) VALUES ('오뚜기');
INSERT INTO company (company_name) VALUES ('해표');
INSERT INTO company (company_name) VALUES ('샘표');
INSERT INTO company (company_name) VALUES ('농협');
INSERT INTO company (company_name) VALUES ('남양');
INSERT INTO company (company_name) VALUES ('빙그레');

INSERT INTO area (area_name, area_x, area_y) VALUES ('채소', 4, 12);
INSERT INTO area (area_name, area_x, area_y) VALUES ('과일', 8, 12);
INSERT INTO area (area_name, area_x, area_y) VALUES ('쌀/잡곡', 2, 16);
INSERT INTO area (area_name, area_x, area_y) VALUES ('견과', 5, 16);
INSERT INTO area (area_name, area_x, area_y) VALUES ('수산물/건어물', 1, 10);
INSERT INTO area (area_name, area_x, area_y) VALUES ('정육/계란', 1, 3);
INSERT INTO area (area_name, area_x, area_y) VALUES ('우유/유제품', 4, 1);
INSERT INTO area (area_name, area_x, area_y) VALUES ('통조림', 4, 4);
INSERT INTO area (area_name, area_x, area_y) VALUES ('냉동/밀키트', 8, 4);
INSERT INTO area (area_name, area_x, area_y) VALUES ('장류/양념', 5, 8);
INSERT INTO area (area_name, area_x, area_y) VALUES ('라면/즉석식품', 4, 4);
INSERT INTO area (area_name, area_x, area_y) VALUES ('커피/차', 7, 1);
INSERT INTO area (area_name, area_x, area_y) VALUES ('생수/음료', 6, 1);
INSERT INTO area (area_name, area_x, area_y) VALUES ('과자/시리얼', 6, 7);

INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('간장', 11, 10, '1L', '샘표 간장 1L', 5000, 10);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('계란', 1, 6, '1판', 'CJ 계란 1판', 3900, 50);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('김밥김', 4, 5, '1봉지', '동원 김밥김 1봉지', 5900, 100);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('생닭', 2, 6, '1000g', '하림 생닭 1마리(대)', 10000, 20);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('참치 통조림', 4, 8, '200g', '동원 살코기 참치 200g', 2000, 25);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('스팸', 6, 8, '340g', '롯데 스팸 클래식 340g', 3000, 55);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('마늘', 1, 1, '200g', 'CJ 마늘 200g', 1500, 100);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('양파', 1, 1, '100g', 'CJ 양파 100g', 2000, 100);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('대파', 1, 1, '1묶음', 'CJ 대파 1묶음', 5000, 100);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('올리브유', 1, 10, '900ml', 'CJ 올리브유 900ml', 7500, 100);
INSERT INTO product (product_name, company_seq, area_seq, weight, product_info, price, stock) 
VALUES ('생닭(팩)', 2, 6, '900g', '하림 무항생제 닭볶음탕용 900g(팩)', 8990, 20);

INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 7, '닭 저렴하게 구매했어요', '닭 저렴하게 구매했어요!!!! 아주 만족스럽습니다.', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 1, '맛있어서 구매했어요', '맛있어서 구매했어요 아주 만족스럽습니다.', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 1, '닭볶음탕 찜닭 해먹었어요', '닭볶음탕 찜닭 해먹었어요', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 10, '닭은 항상 정답입니다!!', '닭은 항상 정답입니다!!', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 1, '맛있어요.', '품질이 만족스럽습니다.', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 2, '품질이 좋아요.', '아주 만족스럽습니다.', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 3, '맛있어요.', '만족스럽습니다.', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 4, '품질이 좋아요.', '아주 만족스럽습니다.', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 1, 'Good', 'Good! 만족스럽습니다.', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 2, '품질이 좋아요.', '아주 만족스럽습니다.', '5');
INSERT INTO product_comment (product_seq, user_seq, title, detail, star_point) 
VALUES (41, 6, '할인할 때 구매했어요', '할인할 때 싸게 구매했어요!', '5');
-----------------------------------------------------------------------
INSERT INTO theme (theme_name) VALUES ('Cookstagram');
INSERT INTO theme (theme_name) VALUES ('백종원');
INSERT INTO theme (theme_name) VALUES ('홈파티');
INSERT INTO theme (theme_name) VALUES ('명절');
INSERT INTO theme (theme_name) VALUES ('생일파티');
INSERT INTO theme (theme_name) VALUES ('다이어트');
INSERT INTO theme (theme_name) VALUES ('보양식');
INSERT INTO theme (theme_name) VALUES ('도시락');
INSERT INTO theme (theme_name) VALUES ('집들이');
INSERT INTO theme (theme_name) VALUES ('술상');
INSERT INTO theme (theme_name) VALUES ('이유식');
INSERT INTO theme (theme_name) VALUES ('브런치');
INSERT INTO theme (theme_name) VALUES ('디저트');

INSERT INTO recipe (theme_seq, admin_chk, recipe_name, detail) 
VALUES (2, true, '백종원 찜닭', '백종원의 찜닭');
INSERT INTO recipe (theme_seq, admin_chk, recipe_name, detail) 
VALUES (1, true, '간장계란밥', '백종원의 간장계란밥 레시피');
INSERT INTO recipe (theme_seq, admin_chk, recipe_name, detail) 
VALUES (3, true, '맛있는 탕수육', '홈파티용 탕수육');
INSERT INTO recipe (theme_seq, admin_chk, recipe_name, detail) 
VALUES (3, true, '맛있는 스팸무스비', '홈파티용 스팸 무스비 레시피');

INSERT INTO recipe (theme_seq, user_seq, recipe_name, detail) 
VALUES (1, 1, '간장계란밥', '간장계란밥 레시피');
INSERT INTO recipe (theme_seq, user_seq, recipe_name, detail) 
VALUES (1, 1, '짜장면', '짜장면 레시피');

INSERT INTO recipe_detail (recipe_seq, product_seq, cnt) VALUES (1, 1, 1);
INSERT INTO recipe_detail (recipe_seq, product_seq, cnt) VALUES (2, 1, 2);

INSERT INTO recipe_comment (recipe_seq, user_seq, recipe_content) 
VALUES (1, 7, '요리해 보고 싶어요!');
INSERT INTO recipe_comment (recipe_seq, user_seq, recipe_content) 
VALUES (2, 1, '맛있어 보여요!');

INSERT INTO recipe_like (user_seq, recipe_seq) VALUES (7, 1);
INSERT INTO recipe_like (user_seq, recipe_seq) VALUES (1, 2);
-----------------------------------------------------------------------
INSERT INTO car (user_seq, car_number) VALUES (1, '01가1234');
INSERT INTO car (user_seq, car_number) VALUES (2, '02나2345');

INSERT INTO card (user_seq, card_number, card_pwd, valid_date) VALUES (1, '0000-0000-0000-0000', '0000', '2027-9-10');
INSERT INTO card (user_seq, card_number, card_pwd, valid_date) VALUES (2, '0000-0000-0000-0001', '1111', '2028-10-3');

INSERT INTO parking (car_seq, in_time, out_time, parking_time, price) 
VALUES (1, '2023-01-10 12:00:00', '2023-01-10 14:00:00', 2, 0);
INSERT INTO parking (car_seq, in_time, out_time, parking_time, price) 
VALUES (2, '2023-01-11 12:00:00', '2023-01-11 14:00:00', 2, 0);

INSERT INTO follow (following_id_seq, follower_id_seq) VALUES (1, 2);
INSERT INTO follow (following_id_seq, follower_id_seq) VALUES (2, 1);
-----------------------------------------------------------------------
INSERT INTO cart (user_seq, cart_name) VALUES (1, '백종원 찜닭 장바구니');
INSERT INTO cart (user_seq, cart_name) VALUES (1, '내일 장 볼 목록');
INSERT INTO cart (user_seq, cart_name) VALUES (2, '참치 요리 장바구니');

INSERT INTO cart_detail (cart_seq, product_seq, cnt, price) 
VALUES (1, 1, 1, (select price from product where product_seq = 1));
INSERT INTO cart_detail (cart_seq, product_seq, cnt, price) 
VALUES (2, 2, 1, (select price from product where product_seq = 2));
-----------------------------------------------------------------------
INSERT INTO purchase (user_seq) VALUES (1);
INSERT INTO purchase (user_seq) VALUES (2);

INSERT INTO purchase_detail (purchase_seq, product_seq, cnt, price, discount_price) 
VALUES (1, 1, 1, (select price from product where product_seq = 1), (select discount_price from product where product_seq = 1));
INSERT INTO purchase_detail (purchase_seq, product_seq, cnt, price, discount_price) 
VALUES (2, 3, 1, (select price from product where product_seq = 3), (select discount_price from product where product_seq = 3));
-----------------------------------------------------------------------