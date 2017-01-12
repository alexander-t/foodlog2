CREATE TYPE total_user_stats AS (days_on_diet INT, total_kcal_in INT, total_kcal_out INT);

CREATE FUNCTION compute_total_stats()
  RETURNS total_user_stats AS $$
DECLARE
  stats total_user_stats%ROWTYPE;
BEGIN
  SELECT
    INTO stats
    (
      SELECT count(DISTINCT date)
      FROM day AS cnt1
    ),
    (SELECT coalesce(sum(kcal_per_day), 0) AS total_kcal_in
     FROM
       (SELECT sum(round(m.portion_in_grams * f.kcal / 100.0)) AS kcal_per_day
        FROM meal m
          JOIN food f ON m.food_id = f.id
        GROUP BY day_id) AS daily_kcals),
    (
      SELECT coalesce(sum(kcal_per_day), 0) AS total_kcal_out
      FROM
        (SELECT sum(used_kcal) AS kcal_per_day
         FROM workout
         GROUP BY day_id) AS daily_workouts);
  RETURN stats;
END;
$$ LANGUAGE plpgsql;
