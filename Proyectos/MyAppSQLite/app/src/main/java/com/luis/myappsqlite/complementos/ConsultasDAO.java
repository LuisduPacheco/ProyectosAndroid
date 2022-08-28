package com.luis.myappsqlite.complementos;

import android.content.Context;

import com.luis.myappsqlite.basededatos.BebidaVO;

public interface ConsultasDAO {

    public boolean insertarBebida (BebidaVO bvo, Context context);

}
