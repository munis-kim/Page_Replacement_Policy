package datatype;

public class Page_Fault_Rate {
    int hit;
    int migrated;
    int page_fault;

    public Page_Fault_Rate() {
        this.hit = 0;
        this.migrated = 0;
        this.page_fault = 0;
    }

    public void setHit() {
        hit++;
    }

    public void setMigrated() {
        migrated++;
    }

    public void setPage_fault() {
        page_fault++;
    }

    public int getHit() {
        return hit;
    }

    public int getMigrated() {
        return migrated;
    }

    public int getPage_fault() {
        return page_fault;
    }
}
