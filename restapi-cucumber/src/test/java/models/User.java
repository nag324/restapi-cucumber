package models;

public class User
{
    private Result[] result;

    private _meta _meta;

    public Result[] getResult ()
    {
        return result;
    }

    public void setResult (Result[] result)
    {
        this.result = result;
    }

    public _meta get_meta ()
    {
        return _meta;
    }

    public void set_meta (_meta _meta)
    {
        this._meta = _meta;
    }


}
