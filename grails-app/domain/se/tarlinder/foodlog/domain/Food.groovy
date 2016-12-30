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

    static constraints = {
        name blank: false, nullable: false
        brand blank: true, nullable: true
        kcal nullable: false, min: 0.0f
        protein nullable: false, min: 0.0f
        carbohydrate nullable: false, min: 0.0f
        fat nullable: false, min: 0.0f
        category inList: ["GREENS", "DAIRY", "MEAT", "POWDER", "BAR", "SOUP", "SWEETS", "BREAD", "OTHER", "DISH"]
        packSizeInGrams nullable: true
    }

    static mapping = {
        id generator:'sequence', params:[sequence:'food_id_seq']
    }

    def getBrandOrEmptyString() {
        brand != null && !brand.equals("") ? "(" + brand + ")" : ""
    }

    def getNameWithPortionSize() {
        name + ((packSizeInGrams != null) ? " (" + packSizeInGrams + "g)" : "")
    }

    @Override
    int compareTo(Food other) {
        name.toUpperCase().compareTo(other.name.toUpperCase())
    }
}
