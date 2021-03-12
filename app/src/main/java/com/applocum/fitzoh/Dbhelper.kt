package com.applocum.fitzoh

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.applocum.fitzoh.ui.goal.models.Goal
import com.applocum.fitzoh.ui.signup.models.User

class Dbhelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "FitZohDatabase"
        private const val TABLE_SIGNUP = "Signup"
        private const val KEY_USERNAME = "username"
        private const val KEY_EMAIL = "email"
        private const val KEY_MOBILE_NUMBER = "mobileno"
        private const val KEY_DATE_OF_BIRTH = "dateofbirth"
        private const val KEY_GENDER = "gender"
        private const val KEY_HEIGHT = "height"
        private const val KEY_WEIGHT = "weight"
        private const val KEY_DAILY_ACTIVITY = "dailyactivity"
        private const val KEY_MEAL_TYPE = "mealtype"
        private const val KEY_CURRENT_BODY_FAT = "currentbodyfat"

        private const val TABLE_Goal = "Goal"
        private const val KEY_BMI = "bmi"
        private const val KEY_BMI_TYPE = "bmitype"
        private const val KEY_WEIGHT_RANGE = "weightrange"
        private const val KEY_TARGET_WEIGHT ="targetweight"
        private const val KEY_FITNESS_GOAL ="fitnessgoal"
        private const val KEY_POSITIVE_HABIT ="positivehabit"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table Signup(userid INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,email TEXT,mobileno TEXT,dateofbirth TEXT,gender TEXT,height TEXT,weight TEXT,dailyactivity TEXT,mealtype TEXT,currentbodyfat TEXT)")
        db?.execSQL("create table Goal(goal_id INTEGER PRIMARY KEY AUTOINCREMENT,bmi TEXT,bmitype TEXT,weightrange TEXT,targetweight TEXT,fitnessgoal TEXT,positivehabit TEXT)")
      //  db?.execSQL("create table Goal(goal_id INTEGER PRIMARY KEY AUTOINCREMENT,bmi TEXT,bmitype TEXT,weightrange TEXT,targetweight TEXT,fitnessgoal TEXT,positivehabit TEXT,u_id INTEGER NOT NULL,FOREIGN KEY(u_id) REFERENCES Goal(userid))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SIGNUP")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_Goal")
        onCreate(db)
    }

    fun signup(user: User) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(KEY_USERNAME, user.userName)
        cv.put(KEY_EMAIL, user.userEmail)
        cv.put(KEY_MOBILE_NUMBER, user.userMobileNumber)
        cv.put(KEY_DATE_OF_BIRTH, user.userDOB)
        cv.put(KEY_GENDER, user.userGender)
        cv.put(KEY_HEIGHT, user.userHeight)
        cv.put(KEY_WEIGHT, user.userWeight)
        cv.put(KEY_DAILY_ACTIVITY, user.userdDailyActivity)
        cv.put(KEY_MEAL_TYPE, user.userMealType)
        cv.put(KEY_CURRENT_BODY_FAT, user.userCurrentBodyFat)
        db.insert(TABLE_SIGNUP, null, cv)
        db.close()

    }

    fun goal(goal: Goal)
    {
        val db=this.writableDatabase
        val cv=ContentValues()
        cv.put(KEY_BMI,goal.gBmi)
        cv.put(KEY_BMI_TYPE,goal.gBmitype)
        cv.put(KEY_WEIGHT_RANGE,goal.gWeightrange)
        cv.put(KEY_TARGET_WEIGHT,goal.gTargetweight)
        cv.put(KEY_FITNESS_GOAL,goal.gFitnessgoaltime)
        cv.put(KEY_POSITIVE_HABIT,goal.gPositivehabit)
        db.insert(TABLE_Goal, null,cv)
        db.close()
    }

    fun signin(email: String): User? {
        val db = this.readableDatabase
        val query: String = "select * from Signup where $KEY_EMAIL = ? or $KEY_MOBILE_NUMBER = ?"
        val cursor = db.rawQuery(query, arrayOf(email))
        var user = User()
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    user = User(
                        cursor.getString(cursor.getColumnIndex(KEY_USERNAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(KEY_MOBILE_NUMBER)),
                        cursor.getString(cursor.getColumnIndex(KEY_DATE_OF_BIRTH)),
                        cursor.getString(cursor.getColumnIndex(KEY_GENDER)),
                        cursor.getString(cursor.getColumnIndex(KEY_HEIGHT)),
                        cursor.getString(cursor.getColumnIndex(KEY_WEIGHT)),
                        cursor.getString(cursor.getColumnIndex(KEY_DAILY_ACTIVITY)),
                        cursor.getString(cursor.getColumnIndex(KEY_MEAL_TYPE)),
                        cursor.getString(cursor.getColumnIndex(KEY_CURRENT_BODY_FAT))
                    )

                    Log.d("Checkk", "--->" + cursor.getString(cursor.getColumnIndex(KEY_USERNAME)))
                    Log.d(
                        "Checkkkkk",
                        "--->" + cursor.getString(cursor.getColumnIndex(KEY_MOBILE_NUMBER))
                    )

                } while (cursor.moveToNext())
            }
        }
        db.close()
        Log.d("Checkk", "-" + user?.userName)
        return user

    }

}