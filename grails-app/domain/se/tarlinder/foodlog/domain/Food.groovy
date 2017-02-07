package se.tarlinder.foodlog.domain

class Food implements Comparable <Food> {
    long id
    String name
    String brand
    float kcal
    float protein
    float carbohydrate
    float fat
    String category
    Long packSizeInGrams
    Integer unitWeight
    String unitLabel

    static constraints = {
        name blank: false, nullable: false
        brand blank: true, nullable: true
        kcal nullable: false, min: 0.0f
        protein nullable: false, min: 0.0f
        carbohydrate nullable: false, min: 0.0f
        fat nullable: false, min: 0.0f
        category nullable: false
        packSizeInGrams nullable: true
        unitWeight nullable: true
        unitLabel nullable: true
    }

    static mapping = {
        id generator:'sequence', params:[sequence:'food_id_seq']
    }

    String getBrandOrEmptyString() {
        brand != null && !brand.equals("") ? "(" + brand + ")" : ""
    }

    String getNameWithPortionSize() {
        name + ((packSizeInGrams != null) ? " (" + packSizeInGrams + "g)" : "")
    }

    @Override
    int compareTo(Food other) {
        name.toUpperCase().compareTo(other.name.toUpperCase())
    }
}
