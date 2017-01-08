CREATE TYPE total_user_stats AS (total_kcal FLOAT, total_kcal_in FLOAT, total_kcal_out FLOAT);

CREATE FUNCTION compute_total_stats()
  RETURNS total_user_stats AS $$
DECLARE
  stats total_user_stats%ROWTYPE;
BEGIN
  SELECT
    INTO stats
    (
      SELECT 2400 * count(DISTINCT date)
      FROM day AS cnt1
    ),
    (SELECT sum(kcal_per_day) AS food_plus
     FROM
       (SELECT sum(round(m.portion_in_grams * f.kcal / 100.0)) AS kcal_per_day
        FROM meal m
          JOIN food f ON m.food_id = f.id
        GROUP BY day_id) AS daily_kcals),
    (
      SELECT sum(kcal_per_day) AS sum_workout_minus
      FROM
        (SELECT sum(used_kcal) AS kcal_per_day
         FROM workout
         GROUP BY day_id) AS daily_workouts);
  RETURN stats;
END;
$$ LANGUAGE plpgsql;
