package se.tarlinder.foodlog;

class AggregatedStats {

    def KCAL_IN_1_KG_FAT = 7700.0

    int energyBalanceKcal
    int foodKcal
    int workoutKcal

    int getKcalDiff() {
        foodKcal - energyBalanceKcal - workoutKcal
    }

    String getKiloDiff() {
        getKcalDiff() != 0 ? String.format("%.1f", getKcalDiff() / KCAL_IN_1_KG_FAT) : "0"
    }
}
