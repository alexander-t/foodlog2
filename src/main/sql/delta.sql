UPDATE FOOD SET category='SAUSAGE' WHERE name = 'Kabanoss - Classic';
UPDATE FOOD SET category='SAUSAGE' WHERE name = 'Ölkorv - Red Devil';
UPDATE FOOD SET unit_weight=60, unit_label='st', category='DAIRY', pack_size_in_grams=NULL WHERE name = 'Ägg';
UPDATE FOOD SET unit_weight=22, unit_label='kaka', category='COOKIES',name='Cookies fyllda - Kola & Chocklad' WHERE name LIKE 'Cookies fyllda - Kola & Chocklad%';
UPDATE FOOD SET unit_weight=5, unit_label='skiva', name='Pepparsalami' WHERE name LIKE 'Pepparsalami %';
UPDATE FOOD SET unit_weight=17, unit_label='bulle', category='FROZEN', name='Grönsaksbullar' WHERE name LIKE 'Grönsaksbullar%';
UPDATE FOOD SET unit_weight=50, unit_label='skiva', name='Proteinbröd' WHERE name LIKE 'Proteinbröd%';
UPDATE FOOD SET unit_weight=50, unit_label='dl', name='Kokosmjölkspulver (coconut milk powder mix)', category='POWDER' WHERE name LIKE 'Kokosmjölkspulver%';
UPDATE FOOD SET unit_weight=120, unit_label='korv', name='Korv - Sorunda Chorizo', category='SAUSAGE' WHERE name LIKE 'Korv - Sorunda Chorizo%';
UPDATE FOOD SET unit_weight=20, unit_label='st', name='Chili bites med paprika och kidneybönor', category='FROZEN' WHERE name LIKE 'Chili bites med paprika och kidneybönor%';
UPDATE FOOD SET unit_weight=50, unit_label='st', name='Potatisbullar', category='FROZEN' WHERE name LIKE 'Potatisbullar%';
UPDATE WORKOUT_TYPE SET average_kcal=500 WHERE name='Bodypump';
UPDATE FOOD SET name = '40% Protein Bar - Crispy Brownie' WHERE name = '40% Protein Bar';
UPDATE WORKOUT_TYPE SET average_kcal=600 WHERE name='Bodycombat';

