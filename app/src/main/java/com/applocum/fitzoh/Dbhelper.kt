package com.applocum.fitzoh

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.applocum.fitzoh.ui.calender.models.Progress
import com.applocum.fitzoh.ui.goal.models.Goal
import com.applocum.fitzoh.ui.home.models.*
import com.applocum.fitzoh.ui.signup.models.User

@Suppress("NAME_SHADOWING")
class Dbhelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "FitZohDatabase"

        private const val TABLE_SIGNUP = "Signup"
        private const val KEY_USERNAME = "username"
        private const val KEY_USERID = "userid"
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
        private const val KEY_TARGET_WEIGHT = "targetweight"
        private const val KEY_FITNESS_GOAL = "fitnessgoal"
        private const val KEY_POSITIVE_HABIT = "positivehabit"

        private const val TABLE_TRAINER = "trainer"
        private const val KEY_TRAINERNAME = "trainername"
        private const val KEY_TRAINER_ID = "trainerid"
        private const val KEY_TRAINERIMAGE = "trainerimage"
        private const val KEY_TRAINEREXPERIENCE = "trainerexperience"
        private const val KEY_TRAINERLANGUAGES = "trainerlanguages"
        private const val KEY_TRAINERABOUT = "trainerabout"
        private const val KEY_TRAINERSESSIONS = "trainersessions"
        private const val KEY_TRAINERSTATUS = "trainerstatus"


        private const val TABLE_COUNSELLOR = "counsellor"
        private const val KEY_COUNSELLOR_ID = "counsellorid"
        private const val KEY_COUNSELLORNAME = "counsellorname"
        private const val KEY_COUNSELLORIMAGE = "counsellorimage"
        private const val KEY_COUNSELLOREXPERIENCE = "counsellorexperience"
        private const val KEY_COUNSELLORLANGUAGES = "counsellorlanguages"
        private const val KEY_COUNSELLORABOUT = "counsellorabout"
        private const val KEY_COUNSELLORPRICE = "counsellorprice"

        private const val TABLE_SLOT_BOOKING = "slotbooking"
        private const val KEY_SLOT_ID = "slotid"
        private const val KEY_SLOT_STARTTIME = "slotstarttime"
        private const val KEY_SLOT_ENDTIME = "slotendtime"
        private const val KEY_SLOT_DATE = "slotdate"
        private const val KEY_SLOT_TIME = "slottime"

        private const val TABLE_FITNESS_LIST = "fitnesstest"
        private const val KEY_FITNESS_LIST_ID = "fitnesstestlistid"
        private const val KEY_FITNESS_LIST_NAME = "fitnesstestlistname"
        private const val KEY_FITNESS_LIST_IMAGE = "fitnesstestlistimage"
        private const val KEY_FITNESS_LIST_ABOUT = "fitnesstestlistabout"
        private const val KEY_FITNESS_LIST_VIDEO = "fitnesstestlistvideo"

        private const val TABLE_MAIN_CATEGORY = "maincategory"
        private const val KEY_MAIN_CATEGORY_ID = "maincategoryid"
        private const val KEY_MAIN_CATEGORY_NAME = "maincategoryname"

        private const val TABLE_SUB_CATEGORY = "subcategory"
        private const val KEY_SUB_CATEGORY_IMAGE = "subcategoryimage"
        private const val KEY_SUB_CATEGORY_VIDEO = "subcategoryvideo"
        private const val KEY_SUB_CATEGORY_ABOUT = "subcategoryabout"


        private const val TABLE_BLOG = "blog"
        private const val KEY_BLOG_ID = "blogid"
        private const val KEY_BLOG_NAME = "blogname"
        private const val KEY_BLOG_IMAGE = "blogimage"
        private const val KEY_BLOG_ABOUT = "blogabout"
        private const val KEY_BLOG_VIDEO = "blogvideo"

        private const val TABLE_NUTRITION_MEAL= "nutritionmeal"
        private const val KEY_NUTRITION_MEAL_ID = "nutritionmealid"
        private const val KEY_NUTRITION_MEAL_NAME = "nutritionmealname"
        private const val KEY_NUTRITION_MEAL_TIME = "nutritionmealtime"
        private const val KEY_NUTRITION_MEAL_FOOD = "nutritionmealfood"
        private const val KEY_NUTRITION_MEAL_NO_OF_SERVING = "nutritionmealnoofserving"
        private const val KEY_NUTRITION_MEAL_SERVING_SIZE = "nutritionmealservingsize"


        private const val TABLE_FITNESS_TEST = "startfitnesstest"
        private const val KEY_FITNESS_TEST_ID = "startfitnesstestid"
        private const val KEY_FITNESS_TEST_DATE= "startfitnesstestdate"
        private const val KEY_FITNESS_TEST_TIME= "startfitnesstesttime"
        private const val KEY_FITNESS_TEST_RESULT= "startfitnesstestresult"
        private const val KEY_FITNESS_TEST_COMMENT = "startfitnesstestcomment"

        private const val TABLE_WORKOUT = "workout"
        private const val KEY_WORKOUT_ID= "workoutid"
        private const val KEY_WORKOUT_NAME= "workoutname"
        private const val KEY_WORKOUT_ABOUT= "workoutabout"
        private const val KEY_WORKOUT_VIDEO= "workoutvideo"
        private const val KEY_WORKOUT_IMAGE= "workoutimage"
        private const val KEY_WORKOUT_STATUS= "workoutstatus"

        private const val TABLE_BASIC_PACKAGE = "basicpackage"
        private const val KEY_BASIC_PACKAGE_ID= "basicpackageid"
        private const val KEY_BASIC_PACKAGE_MONTH= "basicpackagemonth"
        private const val KEY_BASIC_PACKAGE_PRICE= "basicpackageprice"

        private const val TABLE_STANDARD_PACKAGE = "standardpackage"
        private const val KEY_STANDARD_PACKAGE_ID= "standardpackageid"
        private const val KEY_STANDARD_PACKAGE_MONTH= "standardpackagemonth"
        private const val KEY_STANDARD_PACKAGE_PRICE= "standardpackageprice"

        private const val TABLE_PREMIUM_PACKAGE = "premiumpackage"
        private const val KEY_PREMIUM_PACKAGE_ID= "premiumpackageid"
        private const val KEY_PREMIUM_PACKAGE_MONTH= "premiumpackagemonth"
        private const val KEY_PREMIUM_PACKAGE_PRICE= "premiumpackageprice"


        private const val TABLE_SESSION_CATEGORY = "sessioncategory"
        private const val KEY_SESSION_CATEGORY_ID= "sessioncategoryid"
        private const val KEY_SESSION_CATEGORY_IMAGE= "sessioncategoryimage"
        private const val KEY_SESSION_CATEGORY_NAME= "sessioncategoryname"
        private const val KEY_SESSION_CATEGORY_STATUS= "sessioncategorystatus"


        private const val TABLE_SESSION_BOOKING = "sessionbooking"
        private const val TABLE_SESSION_BOOKING_ID = "sessionbookingid"
        private const val KEY_SESSION_BOOKING_DATE= "sessionbookingdate"
        private const val KEY_SESSION_BOOKING_START_TIME= "sessionbookingstarttime"
        private const val KEY_SESSION_BOOKING_END_TIME= "sessionbookingendtime"
        private const val KEY_SESSION_BOOKING_TIME= "sessionbookingtime"

        private const val TABLE_PROGRESS= "progress"
        private const val KEY_PROGRESS_ID= "progressid"
        private const val KEY_PROGRESS_HEIGHT= "progressheight"
        private const val KEY_PROGRESS_WEIGHT= "progressweight"
        private const val KEY_PROGRESS_BODY_FAT= "progressbodyfat"
        private const val KEY_PROGRESS_CHEST= "progresschest"
        private const val KEY_PROGRESS_ARM= "progressarm"

        private const val TABLE_SESSION_SUB_CATEGORY= "sessionsubcategory"
        private const val KEY_SESSION_SUB_CATEGORY_ID= "sessionsubcategoryid"
        private const val KEY_SESSION_SUB_CATEGORY_NAME= "sessionsubcategoryname"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table Signup(userid INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,email TEXT,mobileno TEXT,dateofbirth TEXT,gender TEXT,height TEXT,weight TEXT,dailyactivity TEXT,mealtype TEXT,currentbodyfat TEXT)")
        db?.execSQL("create table Goal(goal_id INTEGER PRIMARY KEY AUTOINCREMENT,bmi TEXT,bmitype TEXT,weightrange TEXT,targetweight TEXT,fitnessgoal TEXT,positivehabit TEXT)")
        db?.execSQL("create table trainer(trainerid INTEGER PRIMARY KEY AUTOINCREMENT,trainername TEXT,trainerimage TEXT,trainerexperience TEXT,trainerlanguages TEXT,trainerabout TEXT,trainersessions TEXT,trainerstatus TEXT,sessionid INTEGER NOT NULL,FOREIGN KEY(sessionid) REFERENCES sessioncategory(sessioncategoryid))")
        db?.execSQL("create table counsellor(counsellorid INTEGER PRIMARY KEY AUTOINCREMENT,counsellorname TEXT,counsellorimage TEXT,counsellorexperience TEXT,counsellorlanguages TEXT,counsellorabout TEXT,counsellorprice TEXT)")
        db?.execSQL("create table slotbooking(slotid INTEGER PRIMARY KEY AUTOINCREMENT,slotdate TEXT,slotstarttime TEXT,slotendtime TEXT,slottime TEXT,tid INTEGER NOT NULL,userid INTEGER NOT NULL,FOREIGN KEY(tid) REFERENCES trainer(trainerid),FOREIGN KEY(userid) REFERENCES trainer(userid))")
        db?.execSQL("create table fitnesstest(fitnesstestlistid INTEGER PRIMARY KEY AUTOINCREMENT,fitnesstestlistname TEXT,fitnesstestlistimage TEXT,fitnesstestlistabout TEXT,fitnesstestlistvideo TEXT)")
        db?.execSQL("create table maincategory(maincategoryid INTEGER PRIMARY KEY AUTOINCREMENT,maincategoryname TEXT)")
        db?.execSQL("create table subcategory(subcategoryid INTEGER PRIMARY KEY AUTOINCREMENT,subcategoryimage TEXT,subcategoryvideo TEXT,subcategoryabout TEXT,cid INTEGER NOT NULL,FOREIGN KEY(cid) REFERENCES maincategory(maincategoryid))")
        db?.execSQL("create table blog(blogid INTEGER PRIMARY KEY AUTOINCREMENT,blogname TEXT,blogimage TEXT,blogabout TEXT,blogvideo TEXT)")
        db?.execSQL("create table nutritionmeal(nutritionmealid INTEGER PRIMARY KEY AUTOINCREMENT,nutritionmealname TEXT,nutritionmealtime TEXT,nutritionmealfood TEXT,nutritionmealnoofserving TEXT,nutritionmealservingsize TEXT)")
        db?.execSQL("create table startfitnesstest(startfitnesstestid INTEGER PRIMARY KEY AUTOINCREMENT,startfitnesstestdate TEXT,startfitnesstesttime TEXT,startfitnesstestresult TEXT,startfitnesstestcomment TEXT,tid INTEGER NOT NULL,FOREIGN KEY(tid) REFERENCES fitnesstest(fitnesstestlistid))")
        db?.execSQL("create table workout(workoutid INTEGER PRIMARY KEY AUTOINCREMENT,workoutname TEXT,workoutabout TEXT,workoutvideo TEXT,workoutimage TEXT,workoutstatus TEXT,userid INTEGER NOT NULL,FOREIGN KEY(userid) REFERENCES Signup(userid))")
        db?.execSQL("create table sessioncategory(sessioncategoryid INTEGER PRIMARY KEY AUTOINCREMENT,sessioncategoryname TEXT,sessioncategoryimage TEXT,sessioncategorystatus TEXT)")
        db?.execSQL("create table basicpackage(basicpackageid INTEGER PRIMARY KEY AUTOINCREMENT,basicpackagemonth TEXT,basicpackageprice TEXT)")
        db?.execSQL("create table standardpackage(standardpackageid INTEGER PRIMARY KEY AUTOINCREMENT,standardpackagemonth TEXT,standardpackageprice TEXT)")
        db?.execSQL("create table premiumpackage(premiumpackageid INTEGER PRIMARY KEY AUTOINCREMENT,premiumpackagemonth TEXT,premiumpackageprice TEXT)")
        db?.execSQL("create table sessionbooking(sessionbookingid INTEGER PRIMARY KEY AUTOINCREMENT,sessionbookingdate TEXT,sessionbookingstarttime TEXT,sessionbookingendtime TEXT,sessionbookingtime TEXT,userid INTEGER NOT NULL,packageid INTEGER NOT NULL,counsellorid INTEGER NOT NULL,trainerid INTEGER NOT NULL,sessioncategoryid INTEGER NOT NULL,FOREIGN KEY(userid) REFERENCES Signup(userid),FOREIGN KEY(packageid) REFERENCES basicpackage(basicpackageid),FOREIGN KEY(counsellorid) REFERENCES counsellor(counsellorid),FOREIGN KEY(trainerid) REFERENCES trainer(trainerid),FOREIGN KEY(sessioncategoryid) REFERENCES sessioncategory(sessioncategoryid))")
        db?.execSQL("create table progress(progressid INTEGER PRIMARY KEY AUTOINCREMENT,progressheight TEXT,progressweight TEXT,progressbodyfat TEXT,progresschest TEXT,progressarm TEXT,userid INTEGER NOT NULL,FOREIGN KEY(userid) REFERENCES Signup(userid))")
        db?.execSQL("create table sessionsubcategory(sessionsubcategoryid INTEGER PRIMARY KEY AUTOINCREMENT,sessionsubcategoryname TEXT,sessioncategoryid INTEGER NOT NULL,FOREIGN KEY(sessioncategoryid) REFERENCES sessioncategory(sessioncategoryid))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SIGNUP")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_Goal")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TRAINER")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_COUNSELLOR")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SLOT_BOOKING")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_FITNESS_LIST")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_MAIN_CATEGORY")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SUB_CATEGORY")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_BLOG")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_FITNESS_TEST")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NUTRITION_MEAL")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_WORKOUT")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_BASIC_PACKAGE")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_STANDARD_PACKAGE")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PREMIUM_PACKAGE")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SESSION_CATEGORY")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SESSION_BOOKING")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PROGRESS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SESSION_SUB_CATEGORY")
        onCreate(db)
    }
    fun sessionsubcategory()
    {
        val db=this.writableDatabase
        db.execSQL("insert into sessionsubcategory(sessionsubcategoryname,sessioncategoryid)" + "values('Jogging','1')")
        db.execSQL("insert into sessionsubcategory(sessionsubcategoryname,sessioncategoryid)" + "values('Swimming','2')")
        db.execSQL("insert into sessionsubcategory(sessionsubcategoryname,sessioncategoryid)" + "values('Biking','3')")
        db.execSQL("insert into sessionsubcategory(sessionsubcategoryname,sessioncategoryid)" + "values('Running','4')")
        db.execSQL("insert into sessionsubcategory(sessionsubcategoryname,sessioncategoryid)" + "values('Walking','5')")
        db.execSQL("insert into sessionsubcategory(sessionsubcategoryname,sessioncategoryid)" + "values('Yoga','6')")
        db.close()
    }

    fun getsessionsubcategory(name: String):ArrayList<String>{
        val db = this.readableDatabase
        val query = "select sessioncategory.sessioncategoryid,sessioncategory.sessioncategoryname,sessioncategory.sessioncategoryimage,sessioncategory.sessioncategorystatus,sessionsubcategory.sessionsubcategoryname FROM sessionsubcategory INNER JOIN sessioncategory ON  sessionsubcategory.sessioncategoryid=sessioncategory.sessioncategoryid where sessioncategory.sessioncategoryname=?"
        val cursor = db.rawQuery(query, arrayOf(name))
        val list:ArrayList<String> = ArrayList()
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                      val name=  cursor.getString(cursor.getColumnIndex(KEY_SESSION_SUB_CATEGORY_NAME))
                     list.add(name)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return list
    }



    fun progress(progress: Progress,id: Int) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(KEY_PROGRESS_HEIGHT,progress.uHeight)
        cv.put(KEY_PROGRESS_WEIGHT,progress.uWeight)
        cv.put(KEY_PROGRESS_BODY_FAT, progress.uBodyfat)
        cv.put(KEY_PROGRESS_CHEST,progress.uChest)
        cv.put(KEY_PROGRESS_ARM,progress.uArm)
        cv.put("userid",id)
        db.insert(TABLE_PROGRESS, null, cv)
        db.close()

    }

    fun getProgress(id:Int):Progress?
    {
        val db = this.readableDatabase
        val query = "select * from progress where userid=?"
        val cursor = db.rawQuery(query, arrayOf(id.toString()))
        var progress= Progress()
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    progress = Progress(
                        cursor.getString(cursor.getColumnIndex(KEY_PROGRESS_HEIGHT)),
                        cursor.getString(cursor.getColumnIndex(KEY_PROGRESS_WEIGHT)),
                        cursor.getString(cursor.getColumnIndex(KEY_PROGRESS_BODY_FAT)),
                        cursor.getString(cursor.getColumnIndex(KEY_PROGRESS_CHEST)),
                        cursor.getString(cursor.getColumnIndex(KEY_PROGRESS_ARM))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_PROGRESS_ID))
                   progress.id = a
                    //mList.add(progress)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return progress
    }



   fun sessionBooking(sessionbooking:Sessionbooking,userid:Int,packageid:Int,counsellorid:Int,trainerid:Int,sessionCategoryid:Int)
    {
        val db=this.writableDatabase
        val cv=ContentValues()
        cv.put(KEY_SESSION_BOOKING_DATE,sessionbooking.sDate)
        cv.put(KEY_SESSION_BOOKING_START_TIME,sessionbooking.sStarttime)
        cv.put(KEY_SESSION_BOOKING_END_TIME,sessionbooking.sEndtime)
        cv.put(KEY_SESSION_BOOKING_TIME,sessionbooking.sTime)
        cv.put("userid",userid)
        cv.put("packageid",packageid)
        cv.put("counsellorid",counsellorid)
        cv.put("trainerid",trainerid)
        cv.put("sessioncategoryid",sessionCategoryid)
        db.insert(TABLE_SESSION_BOOKING, null,cv)
        db.close()

    }

    fun workout()
    {
        val db=this.writableDatabase
        db.execSQL("insert into workout(workoutname,workoutabout,workoutvideo,workoutimage,workoutstatus,userid)" + "values('Barbell Bench Press','05 rounds X 50 / 25 / 12 / 10 / 10','rT7DgCr-3pg','android.resource://com.applocum.fitzoh/drawable/barbell_press','0','1')")
        db.execSQL("insert into workout(workoutname,workoutabout,workoutvideo,workoutimage,workoutstatus,userid)" + "values('Dumbell Press','05 rounds X 10 / 10 / 10 / 10','SHsUIZiNdeY','android.resource://com.applocum.fitzoh/drawable/dumbell_press','0','1')")
        db.execSQL("insert into workout(workoutname,workoutabout,workoutvideo,workoutimage,workoutstatus,userid)" + "values('How To: Dumbbell Chest..','04 rounds X 6-8 6-8 6-8 6-8','VmB1G1K7v94','android.resource://com.applocum.fitzoh/drawable/dumbbell_bench_press','0','1')")
        db.execSQL("insert into workout(workoutname,workoutabout,workoutvideo,workoutimage,workoutstatus,userid)" + "values('Dubell Fly','04 rounds X 12 / 10 / 06 / 06','QENKPHhQVi4','android.resource://com.applocum.fitzoh/drawable/dumbellfly','0','1')")
        db.execSQL("insert into workout(workoutname,workoutabout,workoutvideo,workoutimage,workoutstatus,userid)" + "values('Cable Flys','04 rounds X 15 / 15 / 15 / 15','Iwe6AmxVf7o','android.resource://com.applocum.fitzoh/drawable/cableflys','0','1')")
        db.close()

    }

    fun getworkout():ArrayList<Workout>
    {
        val db = this.readableDatabase
        val query = "select * from workout"
        val mList: ArrayList<Workout> = ArrayList()
        val cursor = db.rawQuery(query, null)
        var workout: Workout
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    workout = Workout(
                        cursor.getString(cursor.getColumnIndex(KEY_WORKOUT_NAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_WORKOUT_ABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_WORKOUT_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_WORKOUT_VIDEO)),
                        cursor.getInt(cursor.getColumnIndex(KEY_WORKOUT_STATUS))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_WORKOUT_ID))
                    workout.id = a
                    mList.add(workout)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }
    fun updateworkout(workout: Workout)
    {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(KEY_WORKOUT_NAME,workout.wName)
        cv.put(KEY_WORKOUT_ABOUT,workout.wAbout)
        cv.put(KEY_WORKOUT_VIDEO,workout.wVideo)
        cv.put(KEY_WORKOUT_IMAGE,workout.wImage)
        cv.put(KEY_WORKOUT_STATUS,workout.wStatus)
        db.update(TABLE_WORKOUT,cv, KEY_WORKOUT_ID + "=" +workout.id,null)
        db.close()
    }

    fun sessioncategory()
    {
        val db=this.writableDatabase
        db.execSQL("insert into sessioncategory(sessioncategoryname,sessioncategoryimage,sessioncategorystatus)" + "values('Strength','android.resource://com.applocum.fitzoh/drawable/strength','0')")
        db.execSQL("insert into sessioncategory(sessioncategoryname,sessioncategoryimage,sessioncategorystatus)" + "values('Power Yoga','android.resource://com.applocum.fitzoh/drawable/img_yoga','0')")
        db.execSQL("insert into sessioncategory(sessioncategoryname,sessioncategoryimage,sessioncategorystatus)" + "values('Mobility & Flexibility','android.resource://com.applocum.fitzoh/drawable/image_flexibility','0')")
        db.execSQL("insert into sessioncategory(sessioncategoryname,sessioncategoryimage,sessioncategorystatus)" + "values('Yoga - Relaxation','android.resource://com.applocum.fitzoh/drawable/image_yogarelex','0')")
        db.execSQL("insert into sessioncategory(sessioncategoryname,sessioncategoryimage,sessioncategorystatus)" + "values('Meditation','android.resource://com.applocum.fitzoh/drawable/img_meditation','0')")
        db.execSQL("insert into sessioncategory(sessioncategoryname,sessioncategoryimage,sessioncategorystatus)" + "values('Powerspeed','android.resource://com.applocum.fitzoh/drawable/image_powerandspeed','0')")
        db.close()
    }
    fun getSessioncategory(): ArrayList<SessionCategory> {
            val db = this.readableDatabase
            val query = "select * from sessioncategory"
            val mList: ArrayList<SessionCategory> = ArrayList()
            val cursor = db.rawQuery(query, null)

        var sessionCategory: SessionCategory

        if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        sessionCategory = SessionCategory(
                            cursor.getString(cursor.getColumnIndex(KEY_SESSION_CATEGORY_IMAGE)),
                            cursor.getString(cursor.getColumnIndex(KEY_SESSION_CATEGORY_NAME)),
                            cursor.getInt(cursor.getColumnIndex(KEY_SESSION_CATEGORY_STATUS)))

                        val a = cursor.getInt(cursor.getColumnIndex(KEY_SESSION_CATEGORY_ID))
                        sessionCategory.id = a
                        mList.add(sessionCategory)
                    } while (cursor.moveToNext())
                }
            }
            db.close()
            cursor.close()
            return mList
        }

    fun trainerprofile() {
        val db = this.writableDatabase
        db.execSQL("insert into trainer(trainername,trainerimage,trainerexperience,trainerlanguages,trainerabout,trainersessions,trainerstatus,sessionid)" + "values('Jhon Martin','android.resource://com.applocum.fitzoh/drawable/jhonmartin','5 years','English','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor dui sit amet arcu luctus mollis. Donec pretium ante vitae urna bibendum, eget feugiat velit consequat. Duis euismod est in tristique rhoncus.','Sesssion-1','0','1')")
        db.execSQL("insert into trainer(trainername,trainerimage,trainerexperience,trainerlanguages,trainerabout,trainersessions,trainerstatus,sessionid)" + "values('Robert Ray','android.resource://com.applocum.fitzoh/drawable/robertroy','4 years','Hindi','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor dui sit amet arcu luctus mollis. Donec pretium ante vitae urna bibendum, eget feugiat velit consequat. Duis euismod est in tristique rhoncus.','Sesssion-1','0','6')")
        db.execSQL("insert into trainer(trainername,trainerimage,trainerexperience,trainerlanguages,trainerabout,trainersessions,trainerstatus,sessionid)" + "values('Jhon Doi','android.resource://com.applocum.fitzoh/drawable/jhondoi','2 years','English','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor dui sit amet arcu luctus mollis. Donec pretium ante vitae urna bibendum, eget feugiat velit consequat. Duis euismod est in tristique rhoncus.','Sesssion-1','0','2')")
        db.execSQL("insert into trainer(trainername,trainerimage,trainerexperience,trainerlanguages,trainerabout,trainersessions,trainerstatus,sessionid)" + "values('Jenna Hopper','android.resource://com.applocum.fitzoh/drawable/ena','2 years','Gujarati','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor dui sit amet arcu luctus mollis. Donec pretium ante vitae urna bibendum, eget feugiat velit consequat. Duis euismod est in tristique rhoncus.','Sesssion-1','0','3')")
        db.execSQL("insert into trainer(trainername,trainerimage,trainerexperience,trainerlanguages,trainerabout,trainersessions,trainerstatus,sessionid)" + "values('EIa Loppes','android.resource://com.applocum.fitzoh/drawable/elaloppes','1 years','French','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor dui sit amet arcu luctus mollis. Donec pretium ante vitae urna bibendum, eget feugiat velit consequat. Duis euismod est in tristique rhoncus.','Sesssion-1','0','4')")
        db.execSQL("insert into trainer(trainername,trainerimage,trainerexperience,trainerlanguages,trainerabout,trainersessions,trainerstatus,sessionid)" + "values('Bewell Bykelly','android.resource://com.applocum.fitzoh/drawable/bewell','2 years','French','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor dui sit amet arcu luctus mollis. Donec pretium ante vitae urna bibendum, eget feugiat velit consequat. Duis euismod est in tristique rhoncus.','Sesssion-1','0','5')")

        db.close()
    }
    fun getallTrainer(): ArrayList<Trainer> {
        val db = this.readableDatabase
        val query = "select * from trainer"
        val mList: ArrayList<Trainer> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var trainer: Trainer

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    trainer = Trainer(
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERNAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERIMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINEREXPERIENCE)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERLANGUAGES)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERSESSIONS)),
                        cursor.getInt(cursor.getColumnIndex(KEY_TRAINERSTATUS)))
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_TRAINER_ID))
                    trainer.id = a
                    mList.add(trainer)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }

    fun gettrainer(): Trainer {
        val db = this.readableDatabase
        val query = "select * from trainer where trainerid= 4"
        val cursor = db.rawQuery(query, null)

        var trainer = Trainer()

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    trainer = Trainer(
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERNAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERIMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINEREXPERIENCE)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERLANGUAGES)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERSESSIONS)),
                        cursor.getInt(cursor.getColumnIndex(KEY_TRAINERSTATUS))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_TRAINER_ID))
                    trainer.id = a
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return trainer
    }

    fun getparticulartrainer(id: Int): ArrayList<Trainer> {
      val db = this.readableDatabase
      val query =
          "select * from trainer where sessionid=?"
      val mListtrainer: ArrayList<Trainer> = ArrayList()
      val cursor = db.rawQuery(query, arrayOf(id.toString()))
        var trainer: Trainer

        if (cursor != null) {
          if (cursor.moveToFirst()) {
              do {

                  trainer = Trainer(
                      cursor.getString(cursor.getColumnIndex(KEY_TRAINERNAME)),
                      cursor.getString(cursor.getColumnIndex(KEY_TRAINERIMAGE)),
                      cursor.getString(cursor.getColumnIndex(KEY_TRAINEREXPERIENCE)),
                      cursor.getString(cursor.getColumnIndex(KEY_TRAINERLANGUAGES)),
                      cursor.getString(cursor.getColumnIndex(KEY_TRAINERABOUT)),
                      cursor.getString(cursor.getColumnIndex(KEY_TRAINERSESSIONS)),
                      cursor.getInt(cursor.getColumnIndex(KEY_TRAINERSTATUS)))
                  val a = cursor.getInt(cursor.getColumnIndex(KEY_TRAINER_ID))
                  trainer.id = a
                  mListtrainer.add(trainer)
              } while (cursor.moveToNext())
          }
      }
         db.close()
        cursor.close()
      return mListtrainer
  }

    fun getTrainerlist(categoryname:String,subcategoryname:String,langauage:String): ArrayList<Trainer> {
        val db = this.readableDatabase
        val query="SELECT * FROM trainer JOIN sessioncategory ON trainer.sessionid=sessioncategory.sessioncategoryid JOIN sessionsubcategory ON sessionsubcategory.sessioncategoryid=sessioncategory.sessioncategoryid where sessionsubcategoryname LIKE '$subcategoryname' AND sessioncategoryname LIKE '$categoryname' AND trainerlanguages LIKE '$langauage'"
         val mList: ArrayList<Trainer> = ArrayList()
        val cursor = db.rawQuery(query, null)
        var trainer: Trainer

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    trainer = Trainer(
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERNAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERIMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINEREXPERIENCE)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERLANGUAGES)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_TRAINERSESSIONS)),
                        cursor.getInt(cursor.getColumnIndex(KEY_TRAINERSTATUS)))
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_TRAINER_ID))
                    trainer.id = a
                    mList.add(trainer)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }

    fun basicpackage()
    {
        val db=this.writableDatabase
        db.execSQL("insert into basicpackage(basicpackagemonth,basicpackageprice)" + "values('Pay 1 Month','$499')")
        db.execSQL("insert into basicpackage(basicpackagemonth,basicpackageprice)" + "values('Pay 2 Month','$599')")
        db.execSQL("insert into basicpackage(basicpackagemonth,basicpackageprice)" + "values('Pay 3 Month','$799')")
        db.close()

    }

    fun getbasicpackage():ArrayList<Packages>
    {
        val db=this.readableDatabase
        val query = "select * from basicpackage"
        val mList: ArrayList<Packages> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var basicPackages: Packages

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    basicPackages = Packages(
                        cursor.getString(cursor.getColumnIndex(KEY_BASIC_PACKAGE_MONTH)),
                        cursor.getString(cursor.getColumnIndex(KEY_BASIC_PACKAGE_PRICE))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_BASIC_PACKAGE_ID))
                    basicPackages.id = a
                    mList.add(basicPackages)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }

    fun standardpackage()
    {
        val db=this.writableDatabase
        db.execSQL("insert into standardpackage(standardpackagemonth,standardpackageprice)" + "values('Pay 1 Month','$899')")
        db.execSQL("insert into standardpackage(standardpackagemonth,standardpackageprice)" + "values('Pay 2 Month','$999')")
        db.execSQL("insert into standardpackage(standardpackagemonth,standardpackageprice)" + "values('Pay 3 Month','$1099')")
        db.close()

    }
    fun getstandardpackage():ArrayList<Packages>
    {
        val db=this.readableDatabase
        val query = "select * from standardpackage"
        val mList: ArrayList<Packages> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var basicPackages: Packages

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    basicPackages = Packages(
                        cursor.getString(cursor.getColumnIndex(KEY_STANDARD_PACKAGE_MONTH)),
                        cursor.getString(cursor.getColumnIndex(KEY_STANDARD_PACKAGE_PRICE))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_STANDARD_PACKAGE_ID))
                    basicPackages.id = a
                    mList.add(basicPackages)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }


    fun premiumpackage()
    {
        val db=this.writableDatabase
        db.execSQL("insert into premiumpackage(premiumpackagemonth,premiumpackageprice)" + "values('Pay 1 Month','$999')")
        db.execSQL("insert into premiumpackage(premiumpackagemonth,premiumpackageprice)" + "values('Pay 2 Month','$1199')")
        db.execSQL("insert into premiumpackage(premiumpackagemonth,premiumpackageprice)" + "values('Pay 3 Month','$1399')")
        db.close()

    }
    fun getpremiumpackage():ArrayList<Packages>
    {
        val db=this.readableDatabase
        val query = "select * from premiumpackage"
        val mList: ArrayList<Packages> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var basicPackages: Packages

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    basicPackages = Packages(
                        cursor.getString(cursor.getColumnIndex(KEY_PREMIUM_PACKAGE_MONTH)),
                        cursor.getString(cursor.getColumnIndex(KEY_PREMIUM_PACKAGE_PRICE))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_PREMIUM_PACKAGE_ID))
                    basicPackages.id = a
                    mList.add(basicPackages)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }


    fun slotbooking() {
        val db = this.writableDatabase
        db.execSQL("insert into slotbooking(slotdate,slotstarttime,slotendtime,slottime,tid,userid)" + "values(Date(),'07:00 AM','10:00 PM','12:00 PM','4','1')")
        db.close()
    }

  /*  fun getslotbooking(date: String): Slotbooking?{
        val db = this.readableDatabase
        val query = "select * from 'slotbooking' where slotdate=?"
        val cursor = db.rawQuery(query, arrayOf(date))
        var slotbooking:Slotbooking?= Slotbooking()

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    slotbooking = Slotbooking(
                        cursor.getString(cursor.getColumnIndex(KEY_SLOT_DATE)),
                        cursor.getString(cursor.getColumnIndex(KEY_SLOT_STARTTIME)),
                        cursor.getString(cursor.getColumnIndex(KEY_SLOT_ENDTIME)),
                        cursor.getString(cursor.getColumnIndex(KEY_SLOT_TIME))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_SLOT_ID))
                    slotbooking.id = a
                } while (cursor.moveToNext())
            }
        }
        else {
            slotbooking=null
        }
        db.close()
        cursor.close()
        return slotbooking
    }*/

    fun getallslotbooking(): Slotbooking? {
        val db = this.readableDatabase
        val query = "select * from slotbooking"
        val cursor = db.rawQuery(query,null)
        var slotbooking:Slotbooking? = Slotbooking()

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    slotbooking = Slotbooking(
                        cursor.getString(cursor.getColumnIndex(KEY_SLOT_DATE)),
                        cursor.getString(cursor.getColumnIndex(KEY_SLOT_STARTTIME)),
                        cursor.getString(cursor.getColumnIndex(KEY_SLOT_ENDTIME))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_SLOT_ID))
                    slotbooking.id = a
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return slotbooking
    }

    fun fitnesstest(fitnessTest: FitnessTest,id: Int) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(KEY_FITNESS_TEST_DATE,fitnessTest.fDate)
        cv.put(KEY_FITNESS_TEST_TIME,fitnessTest.fTime)
        cv.put(KEY_FITNESS_TEST_RESULT,fitnessTest.fResult)
        cv.put(KEY_FITNESS_TEST_COMMENT,fitnessTest.fComment)
        cv.put("tid",id)
        db.insert(TABLE_FITNESS_TEST, null,cv)
        db.close()
    }

    fun getFitnesstest(id:Int): ArrayList<FitnessTest> {
        val db = this.readableDatabase
        val query = "select * from startfitnesstest where tid=?"
        val mList: ArrayList<FitnessTest> = ArrayList()
        val cursor = db.rawQuery(query, arrayOf(id.toString()))

        var fitnessTest: FitnessTest

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    fitnessTest = FitnessTest(
                        cursor.getString(cursor.getColumnIndex(KEY_FITNESS_TEST_DATE)),
                        cursor.getString(cursor.getColumnIndex(KEY_FITNESS_TEST_TIME)),
                        cursor.getString(cursor.getColumnIndex(KEY_FITNESS_TEST_RESULT)),
                        cursor.getString(cursor.getColumnIndex(KEY_FITNESS_TEST_COMMENT))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_FITNESS_TEST_ID))
                    fitnessTest.id = a
                    mList.add(fitnessTest)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }

    fun nutritionMeal(nutritionMeal: NutritionMeal)
    {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(KEY_NUTRITION_MEAL_NAME,nutritionMeal.nName)
        cv.put(KEY_NUTRITION_MEAL_TIME,nutritionMeal.nTime)
        cv.put(KEY_NUTRITION_MEAL_FOOD,nutritionMeal.nFood)
        cv.put(KEY_NUTRITION_MEAL_NO_OF_SERVING,nutritionMeal.nNoofserving)
        cv.put(KEY_NUTRITION_MEAL_SERVING_SIZE,nutritionMeal.nServingsize)
        db.insert(TABLE_NUTRITION_MEAL, null, cv)
        db.close()
    }
    fun getNutritionMeal(): ArrayList<NutritionMeal> {
        val db = this.readableDatabase
        val query = "select * from nutritionmeal"
        val mList: ArrayList<NutritionMeal> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var nutritionMeal: NutritionMeal

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    nutritionMeal = NutritionMeal(
                        cursor.getString(cursor.getColumnIndex(KEY_NUTRITION_MEAL_NAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_NUTRITION_MEAL_TIME)))
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_NUTRITION_MEAL_ID))
                    nutritionMeal.id = a
                    mList.add(nutritionMeal)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }
    fun updatenutritionMeal(nutritionMeal: NutritionMeal,id: Int)
    {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(KEY_NUTRITION_MEAL_NAME,nutritionMeal.nName)
        cv.put(KEY_NUTRITION_MEAL_TIME,nutritionMeal.nTime)
        cv.put(KEY_NUTRITION_MEAL_FOOD,nutritionMeal.nFood)
        cv.put(KEY_NUTRITION_MEAL_NO_OF_SERVING,nutritionMeal.nNoofserving)
        cv.put(KEY_NUTRITION_MEAL_SERVING_SIZE,nutritionMeal.nServingsize)
        db.update(TABLE_NUTRITION_MEAL,cv, "$KEY_NUTRITION_MEAL_ID=$id",null)
        db.close()
    }
    fun deletenutritionmeal(id: Int):NutritionMeal
    {
        val db=this.writableDatabase
        val nutritionMeal=NutritionMeal()
        db.delete(TABLE_NUTRITION_MEAL, "$KEY_NUTRITION_MEAL_ID=$id", null)
        db.close()
        return nutritionMeal
    }
    fun getAllNutritionMeal(): ArrayList<NutritionMeal> {
        val db = this.readableDatabase
        val query = "select * from nutritionmeal"
        val mList: ArrayList<NutritionMeal> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var nutritionMeal: NutritionMeal

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    nutritionMeal = NutritionMeal(
                        cursor.getString(cursor.getColumnIndex(KEY_NUTRITION_MEAL_NAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_NUTRITION_MEAL_TIME)),
                        cursor.getString(cursor.getColumnIndex(KEY_NUTRITION_MEAL_FOOD)),
                        cursor.getString(cursor.getColumnIndex(KEY_NUTRITION_MEAL_NO_OF_SERVING)),
                        cursor.getString(cursor.getColumnIndex(KEY_NUTRITION_MEAL_SERVING_SIZE)))
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_NUTRITION_MEAL_ID))
                    nutritionMeal.id = a
                    mList.add(nutritionMeal)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
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
    fun updateprofile(user: User?,id: Int?)
    {
        val db=this.writableDatabase
        val cv=ContentValues()
        cv.put(KEY_USERNAME, user?.userName)
        cv.put(KEY_EMAIL, user?.userEmail)
        cv.put(KEY_MOBILE_NUMBER, user?.userMobileNumber)
        cv.put(KEY_DATE_OF_BIRTH, user?.userDOB)
        cv.put(KEY_GENDER, user?.userGender)
        cv.put(KEY_HEIGHT, user?.userHeight)
        cv.put(KEY_WEIGHT, user?.userWeight)
        cv.put(KEY_DAILY_ACTIVITY, user?.userdDailyActivity)
        cv.put(KEY_MEAL_TYPE, user?.userMealType)
        cv.put(KEY_CURRENT_BODY_FAT, user?.userCurrentBodyFat)
        db.update(TABLE_SIGNUP,cv, "$KEY_USERID=$id",null)
        db.close()
    }

    fun signin(email: String): User? {
        val db = this.readableDatabase
        val query: String = "select * from Signup where $KEY_EMAIL =?"
        val cursor = db.rawQuery(query, arrayOf(email))
        val mList:ArrayList<User> = ArrayList()
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
                    val a=cursor.getInt(cursor.getColumnIndex(KEY_USERID))
                    user.id=a
                    mList.add(user)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return user
    }

    fun maincategory() {
        val db = this.writableDatabase

        db.execSQL("insert into maincategory(maincategoryname)" + "values('ALL')")
        db.execSQL("insert into maincategory(maincategoryname)" + "values('MIND')")
        db.execSQL("insert into maincategory(maincategoryname)" + "values('RELATIONSHIPS')")
        db.execSQL("insert into maincategory(maincategoryname)" + "values('PERFORMANCE')")
        db.execSQL("insert into maincategory(maincategoryname)" + "values('FRIENDSHIPS')")
        db.close()
    }
    fun getmaincategory(): ArrayList<Category> {
        val db = this.readableDatabase
        val query = "select * from maincategory"
        val mList: ArrayList<Category> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var category: Category

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    category = Category(
                        cursor.getString(cursor.getColumnIndex(KEY_MAIN_CATEGORY_NAME))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_MAIN_CATEGORY_ID))
                    category.id = a
                    mList.add(category)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }

    fun blog() {
        val db = this.writableDatabase
        db.execSQL("insert into blog(blogname,blogimage,blogabout,blogvideo)" + "values('Beginners','android.resource://com.applocum.fitzoh/drawable/img_beginner','lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_duis_est_est_mattis_sit_amet_tristique_in_consequat_ac_sap_curabitur_vitae_quam_sed_quam_tincidunt_lobortis_in_maximus_rhoncus_tellus_non_dignissim_duis_vulputate_non_lorem_sit_amet_venenatis_phasellus_efficitur_ante_fringilla_ultrices_augue_vitae_congue_mauris\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis est est, mattis sit amet tristique in, consequat ac sap Curabitur vitae quam sed quam tincidunt lobortis. In maximus rhoncus tellus non dignissim. Duis vulputate non lorem sit amet venenatis. Phasellus efficitur ante fringilla, ultrices augue vitae, congue mauris.','gC_L9qAHVJ8')")
        db.execSQL("insert into blog(blogname,blogimage,blogabout,blogvideo)" + "values('Intermediate','android.resource://com.applocum.fitzoh/drawable/img_intermedeter','lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_duis_est_est_mattis_sit_amet_tristique_in_consequat_ac_sap_curabitur_vitae_quam_sed_quam_tincidunt_lobortis_in_maximus_rhoncus_tellus_non_dignissim_duis_vulputate_non_lorem_sit_amet_venenatis_phasellus_efficitur_ante_fringilla_ultrices_augue_vitae_congue_mauris\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis est est, mattis sit amet tristique in, consequat ac sap Curabitur vitae quam sed quam tincidunt lobortis. In maximus rhoncus tellus non dignissim. Duis vulputate non lorem sit amet venenatis. Phasellus efficitur ante fringilla, ultrices augue vitae, congue mauris.','Ba3qZjzPonI')")
        db.execSQL("insert into blog(blogname,blogimage,blogabout,blogvideo)" + "values('Advance','android.resource://com.applocum.fitzoh/drawable/jhondoi','lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_duis_est_est_mattis_sit_amet_tristique_in_consequat_ac_sap_curabitur_vitae_quam_sed_quam_tincidunt_lobortis_in_maximus_rhoncus_tellus_non_dignissim_duis_vulputate_non_lorem_sit_amet_venenatis_phasellus_efficitur_ante_fringilla_ultrices_augue_vitae_congue_mauris\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis est est, mattis sit amet tristique in, consequat ac sap Curabitur vitae quam sed quam tincidunt lobortis. In maximus rhoncus tellus non dignissim. Duis vulputate non lorem sit amet venenatis. Phasellus efficitur ante fringilla, ultrices augue vitae, congue mauris.','9IZuslMXpkI')")
        db.close()
    }
    fun getblog(): ArrayList<Blog> {
        val db = this.readableDatabase
        val query = "select * from blog"
        val mList: ArrayList<Blog> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var blog: Blog

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    blog = Blog(
                        cursor.getString(cursor.getColumnIndex(KEY_BLOG_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_BLOG_NAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_BLOG_ABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_BLOG_VIDEO))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_BLOG_ID))
                    blog.id = a
                    mList.add(blog)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }

    fun fitnesslist() {
        val db = this.writableDatabase
        db.execSQL("insert into fitnesstest(fitnesstestlistname,fitnesstestlistimage,fitnesstestlistabout,fitnesstestlistvideo)" + "values('Respiratory & Stamina','android.resource://com.applocum.fitzoh/drawable/image_respirateryandstamina','Respiratory & Stamina','saXF2xH3A2U')")
        db.execSQL("insert into fitnesstest(fitnesstestlistname,fitnesstestlistimage,fitnesstestlistabout,fitnesstestlistvideo)" + "values('Cardiovasular Endurance','android.resource://com.applocum.fitzoh/drawable/image_cardiovasularendurance','Cardiovasular Endurance','50kH47ZztHs')")
        db.execSQL("insert into fitnesstest(fitnesstestlistname,fitnesstestlistimage,fitnesstestlistabout,fitnesstestlistvideo)" + "values('Strength - Upper Body','android.resource://com.applocum.fitzoh/drawable/image_strength_upperbody','Strength - Upper Body','_t8fJffsZzk')")
        db.execSQL("insert into fitnesstest(fitnesstestlistname,fitnesstestlistimage,fitnesstestlistabout,fitnesstestlistvideo)" + "values('Strength - Lower Body','android.resource://com.applocum.fitzoh/drawable/image_strength_lowerbody','Strength - Lower Body','eemRXHKsGIc')")
        db.execSQL("insert into fitnesstest(fitnesstestlistname,fitnesstestlistimage,fitnesstestlistabout,fitnesstestlistvideo)" + "values('Flexibility','android.resource://com.applocum.fitzoh/drawable/image_flexibility','Flexibility','L_xrDAtykMI')")
        db.execSQL("insert into fitnesstest(fitnesstestlistname,fitnesstestlistimage,fitnesstestlistabout,fitnesstestlistvideo)" + "values('Power & Speed','android.resource://com.applocum.fitzoh/drawable/image_powerandspeed','Power & Speed','FYJJbwG_i8U')")
        db.close()
    }
    fun getfitnesslist(): ArrayList<ListOfTest> {
        val db = this.readableDatabase
        val query = "select * from fitnesstest"
        val mList: ArrayList<ListOfTest> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var listOfTest: ListOfTest

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    listOfTest = ListOfTest(
                        cursor.getString(cursor.getColumnIndex(KEY_FITNESS_LIST_NAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_FITNESS_LIST_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_FITNESS_LIST_ABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_FITNESS_LIST_VIDEO))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_FITNESS_LIST_ID))
                    listOfTest.id = a
                    mList.add(listOfTest)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }

    fun counsellorprofile() {
        val db = this.writableDatabase
        db.execSQL("insert into counsellor(counsellorname,counsellorimage,counsellorexperience,counsellorlanguages,counsellorabout,counsellorprice)" + "values('Bewell Bykelly','android.resource://com.applocum.fitzoh/drawable/bewell','5 years','English','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor dui sit amet arcu luctus mollis. Donec pretium ante vitae urna bibendum, eget feugiat velit consequat. Duis euismod est in tristique rhoncus.','$499')")
        db.execSQL("insert into counsellor(counsellorname,counsellorimage,counsellorexperience,counsellorlanguages,counsellorabout,counsellorprice)" + "values('Jenna Hopper','android.resource://com.applocum.fitzoh/drawable/ena','4 years','English','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed porttitor dui sit amet arcu luctus mollis. Donec pretium ante vitae urna bibendum, eget feugiat velit consequat. Duis euismod est in tristique rhoncus.','$599')")
        db.close()
    }

    fun getcounsellor(): Counsellor {
        val db = this.readableDatabase
        val query = "select * from counsellor where counsellorid= 1"
        val cursor = db.rawQuery(query, null)
        var counsellor = Counsellor()

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    counsellor = Counsellor(
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORNAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORIMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLOREXPERIENCE)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORLANGUAGES)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORPRICE))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_COUNSELLOR_ID))
                    counsellor.id = a
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return counsellor
    }

    fun getallCounselloers(): ArrayList<Counsellor> {
        val db = this.readableDatabase
        val query = "select * from counsellor"
        val mList: ArrayList<Counsellor> = ArrayList()
        val cursor = db.rawQuery(query, null)

        var counsellor: Counsellor

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    counsellor = Counsellor(
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORNAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORIMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLOREXPERIENCE)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORLANGUAGES)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_COUNSELLORPRICE))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_COUNSELLOR_ID))
                    counsellor.id = a
                    mList.add(counsellor)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }


    fun mysubcategory() {
        val db = this.writableDatabase
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/mindimage1','pCpiteBel8E','Mind Video 1','2')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/mindimage2','jwlNOUnGqYA','Mind Video 2','2')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/mindimage3','Q-DXxB_5e28','Mind Video 3','2')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/mindimage1','GYe1WeAEbZY','Mind Video 4','2')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/relationshipimage1','d4nZy4maiIg','Relationship Video 1','3')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/relationshipimage2','6q4IUQzt3dA','Relationship Video 2','3')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/relationshipimage3','tD-4Vm0AY28','Relationship Video 3','3')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/relationshipimage1','_PoBCFGRcZ8','Relationship Video 4','3')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/mindimage1','IBuwNheltdI','Perfomance Video 1','4')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/mindimage2','zGR0lgoVEjc','Perfomance Video 2','4')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/mindimage2','saXF2xH3A2U','Perfomance Video 3','4')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/mindimage1','3FCqd4B5l3A','Perfomance Video 4','4')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/relationshipimage1','lBuqPqds0KM','Friendships Video 1','5')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/relationshipimage2','3K6XGxO8jhw','Friendships Video 2','5')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/relationshipimage3','5hFrEtQpEZA','Friendships Video 3','5')")
        db.execSQL("insert into subcategory(subcategoryimage,subcategoryvideo,subcategoryabout,cid)" + "values('android.resource://com.applocum.fitzoh/drawable/relationshipimage1','GpgMtCmselo','Friendships Video 4','5')")
        db.close()
    }

    fun getAll(): ArrayList<CategoryRaw> {
        val db = this.readableDatabase
        val query =
            "select distinct maincategory.maincategoryid,maincategory.maincategoryname,subcategory.subcategoryimage,subcategory.subcategoryvideo,subcategory.subcategoryabout FROM maincategory INNER JOIN subcategory ON maincategory.maincategoryid=subcategory.cid order by subcategory.subcategoryimage"
        val mList: ArrayList<CategoryRaw> = ArrayList()
        val cursor = db.rawQuery(query, null)
        var categoryRaw: CategoryRaw

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    categoryRaw = CategoryRaw(
                        cursor.getString(cursor.getColumnIndex(KEY_MAIN_CATEGORY_NAME))
                    )
                    val a = cursor.getInt(cursor.getColumnIndex(KEY_MAIN_CATEGORY_ID))
                    categoryRaw.id=a
                    mList.add(categoryRaw)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mList
    }

    fun getMind(): ArrayList<Categories> {
        val db = this.readableDatabase
        val query =
            "select subcategory.subcategoryimage,subcategory.subcategoryvideo,subcategory.subcategoryabout FROM maincategory INNER JOIN subcategory ON maincategory.maincategoryid=subcategory.cid WHERE maincategory.maincategoryid=2"
        val mListCategory: ArrayList<Categories> = ArrayList()
        val cursor = db.rawQuery(query, null)
        var categories: Categories

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    categories = Categories(
                        cursor.getString(cursor.getColumnIndex(KEY_SUB_CATEGORY_IMAGE)),
                        cursor.getString(cursor.getColumnIndex(KEY_SUB_CATEGORY_ABOUT)),
                        cursor.getString(cursor.getColumnIndex(KEY_SUB_CATEGORY_VIDEO)))
                    mListCategory.add(categories)
                    Log.d("videooooo","--->"+cursor.getString(cursor.getColumnIndex(KEY_SUB_CATEGORY_VIDEO)))
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mListCategory
    }
    fun getRelationships(): ArrayList<Categories> {
        val db = this.readableDatabase
        val query =
            "select subcategory.subcategoryimage,subcategory.subcategoryvideo,subcategory.subcategoryabout FROM maincategory INNER JOIN subcategory ON maincategory.maincategoryid=subcategory.cid WHERE maincategory.maincategoryid=3"
        val mListCategory: ArrayList<Categories> = ArrayList()
        val cursor = db.rawQuery(query, null)
        var categories: Categories

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    categories = Categories(
                        cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_IMAGE
                            )
                        ), cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_ABOUT
                            )
                        ), cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_VIDEO
                            )
                        )
                    )
                    mListCategory.add(categories)

                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mListCategory
    }
    fun getPerfomance(): ArrayList<Categories> {
        val db = this.readableDatabase
        val query =
            "select subcategory.subcategoryimage,subcategory.subcategoryvideo,subcategory.subcategoryabout FROM maincategory INNER JOIN subcategory ON maincategory.maincategoryid=subcategory.cid WHERE maincategory.maincategoryid=4"
        val mListCategory: ArrayList<Categories> = ArrayList()
        val cursor = db.rawQuery(query, null)
        var categories: Categories

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    categories = Categories(
                        cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_IMAGE
                            )
                        ), cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_ABOUT
                            )
                        ), cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_VIDEO
                            )
                        )
                    )
                    mListCategory.add(categories)

                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mListCategory
    }
    fun getFriendships(): ArrayList<Categories> {
        val db = this.readableDatabase
        val query =
            "select subcategory.subcategoryimage,subcategory.subcategoryvideo,subcategory.subcategoryabout FROM maincategory INNER JOIN subcategory ON maincategory.maincategoryid=subcategory.cid WHERE maincategory.maincategoryid=5"
        val mListCategory: ArrayList<Categories> = ArrayList()
        val cursor = db.rawQuery(query, null)
        var categories: Categories

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    categories = Categories(
                        cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_IMAGE
                            )
                        ), cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_ABOUT
                            )
                        ), cursor.getString(
                            cursor.getColumnIndex(
                                KEY_SUB_CATEGORY_VIDEO
                            )
                        )
                    )
                    mListCategory.add(categories)
                } while (cursor.moveToNext())
            }
        }
        db.close()
        cursor.close()
        return mListCategory
    }

    fun goal(goal: Goal) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(KEY_BMI, goal.gBmi)
        cv.put(KEY_BMI_TYPE, goal.gBmitype)
        cv.put(KEY_WEIGHT_RANGE, goal.gWeightrange)
        cv.put(KEY_TARGET_WEIGHT, goal.gTargetweight)
        cv.put(KEY_FITNESS_GOAL, goal.gFitnessgoaltime)
        cv.put(KEY_POSITIVE_HABIT, goal.gPositivehabit)
        db.insert(TABLE_Goal, null, cv)
        db.close()
    }
}