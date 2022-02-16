package model_zero

class Castle {
    String name
    String city
    String state
    double longitude
    double latitude

    String toString(){"$name Castle"}

    static hasMany = [knights: Knight]
 
    static constraints = {
        name blank:false
        city blank:false
        state blank:false
        latitude min: -90d, max: 90d
        longitude()
        knights()
    }
}
