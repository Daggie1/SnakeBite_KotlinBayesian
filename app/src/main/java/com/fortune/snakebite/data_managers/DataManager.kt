package com.fortune.snakebite.data_managers

object DataManager {
    val disease = HashMap<String, Disease>()


    init {
        initializeDiseases()

    }

    private fun initializeDiseases() {
        //disease 1
        var disease = Disease(
            diseaseId= "SALMONELLA",
            title= "SALMONELLA",
            causingSnake="Cobra Families",
            symptom =  arrayOf(
                "diarrhea",
                "headache",
                "fever and stomach cramps" ,
                "  septicaemia -blood poisoning"
            ),
           treatment =  arrayOf(
                "Cover the affected area",
                "Avoid walking alot",
               "Visit the recommended pharmacy"
            ),
            pharmacy = arrayOf(
                "Nyeri Medical"
            )

        )
        DataManager.disease.set(disease.diseaseId, disease)
        //diseas2
disease=Disease(
    diseaseId= "BOTULISM",
   title= "BOTULISM",
   causingSnake="Python Families",
    symptom = arrayOf(
        "paralysis",
        "spores",
        "Sores",
        "Affeted area turns greenish"
    ),
    treatment = arrayOf(
        "Cover the affected area",
        "Avoid walking alot",
        "Visit the recommended pharmacy"
    ),
    pharmacy = arrayOf(
        "Nyaribo Pharmacy",
        "Dkut Medical Center"
    )

)
        DataManager.disease.set(disease.diseaseId, disease)
        //disease3
        disease=Disease(
            diseaseId= "LEPTOSPIROSIS",
            title= "LEPTOSPIROSIS",
            causingSnake="Anacoda Families",
            symptom = arrayOf(
                "Acratches on your body",
                "Abnormal  lining of the mouth, throat and eyes",
                "Flu-like illness",
                "persistent and severe headache"
            ),
            treatment = arrayOf(
                "Do physical exercises",
                "Avoid contact with urine of animals carrying the bacterium",
                "Visit the recommended pharmacy"
            ),
            pharmacy = arrayOf(
                "Mweiga Pharmacy",
                "Dkut Medical Center"
            )

        )
        DataManager.disease.set(disease.diseaseId, disease)
        disease=Disease(
            diseaseId= "CAMPYLOBACTERIOSIS",
            title= "CAMPYLOBACTERIOSIS",
            causingSnake="Viper Families",
            symptom = arrayOf(
                "Abdominal pain and fever within 2-5 day",
                " Diarrhea",
                "Blood stool"

            ),
            treatment = arrayOf(
                "Do physical exercises",
                "Take alot of vitamins",
                "Visit the recommended pharmacy"
            ),
            pharmacy = arrayOf(
                "Shirikisho Pharmacy",
                "Dkut Medical Center"
            )

        )
        DataManager.disease.set(disease.diseaseId, disease)
    }
//add others

fun findDiseaseById(diseaseId:String):Disease{
    return disease[diseaseId]!!
}
    fun findDiseaseSymptomById(diseaseId:String):Array<String>{
        return disease[diseaseId]!!.symptom
    }
    fun findTreatmentsSymptomById(diseaseId:String):Array<String>{
        return disease[diseaseId]!!.treatment
    }
    fun findChemistSymptomById(diseaseId:String):Array<String>{
        return disease[diseaseId]!!.pharmacy
    }
    fun getAllSymptoms():ArrayList<String>{
        var diseasearray= arrayListOf<String>()
        disease.values.toList().forEach {dis->
            diseasearray.addAll(dis.symptom.toList())
        }
        return diseasearray
    }

}