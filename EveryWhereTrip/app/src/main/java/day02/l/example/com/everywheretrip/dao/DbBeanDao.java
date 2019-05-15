package day02.l.example.com.everywheretrip.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import day02.l.example.com.everywheretrip.trip.bean.DbBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DB_BEAN".
*/
public class DbBeanDao extends AbstractDao<DbBean, Long> {

    public static final String TABLENAME = "DB_BEAN";

    /**
     * Properties of entity DbBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Location = new Property(2, String.class, "location", false, "LOCATION");
        public final static Property Occupation = new Property(3, String.class, "occupation", false, "OCCUPATION");
        public final static Property Photo = new Property(4, String.class, "photo", false, "PHOTO");
    }


    public DbBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DbBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DB_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"LOCATION\" TEXT," + // 2: location
                "\"OCCUPATION\" TEXT," + // 3: occupation
                "\"PHOTO\" TEXT);"); // 4: photo
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DB_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DbBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(3, location);
        }
 
        String occupation = entity.getOccupation();
        if (occupation != null) {
            stmt.bindString(4, occupation);
        }
 
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(5, photo);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DbBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(3, location);
        }
 
        String occupation = entity.getOccupation();
        if (occupation != null) {
            stmt.bindString(4, occupation);
        }
 
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(5, photo);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DbBean readEntity(Cursor cursor, int offset) {
        DbBean entity = new DbBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // location
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // occupation
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // photo
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DbBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLocation(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setOccupation(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhoto(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DbBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DbBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DbBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}