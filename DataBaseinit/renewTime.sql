use microheadlines;

update news_headline set create_time=now(), update_time=now();
select * from news_headline LIMIT 20;