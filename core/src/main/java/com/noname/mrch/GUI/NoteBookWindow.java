package com.noname.mrch.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.noname.mrch.GameWorld;
import com.noname.mrch.gameobject.GameActor;
import com.noname.mrch.gameobject.NoteBook;

/**
 * Window that displays data in notebook
 */

class NoteBookWindow extends GuiWindow {
    private final int COLUMN_COUNT = 4;
    private final float SLOT_WIDTH = 150;
    private final float SLOT_GAP_HORIZONTAL = 100;
    private final float SLOT_GAP_VERTICAL = SLOT_GAP_HORIZONTAL * 0.25f;
    private final float WINDOW_WIDTH = SLOT_WIDTH * COLUMN_COUNT + SLOT_GAP_HORIZONTAL * (COLUMN_COUNT - 1) * 1.1f;
    private final float WINDOW_HEIGHT = 700;

    NoteBookWindow(Skin skin, Gui gui, GameWorld gameWorld) {
        super("NOTEBOOK", skin, gui, gameWorld);

        button("OK", true);
    }

    /**
     * called every time notebook is opened. Clears all the children and rebuild.
     */
    void refresh(){
        NoteBook noteBook = gameWorld.getNotebook();
        getContentTable().clear();
        getContentTable().align(Align.topLeft);

        Array<GameActor> entryArray = new Array<>();
        entryArray.addAll(noteBook.getClueList());
        entryArray.addAll(noteBook.getItemList());

        for (int i = 0; i < entryArray.size; i++){
            Slot slot = new Slot(entryArray.get(i), gui, getSkin());

            if ((i+1) % COLUMN_COUNT == 0){
                getContentTable().add(slot).width(SLOT_WIDTH).padTop(SLOT_GAP_VERTICAL)
                        .padBottom(SLOT_GAP_VERTICAL).row();
            }
            else{
                getContentTable().add(slot).width(SLOT_WIDTH).padTop(SLOT_GAP_VERTICAL)
                        .padBottom(SLOT_GAP_VERTICAL).padRight(SLOT_GAP_HORIZONTAL);
            }
        }
    }

    @Override
    public float getPrefWidth() {
        return WINDOW_WIDTH;
    }

    @Override
    public float getPrefHeight() {
        return WINDOW_HEIGHT;
    }

    @Override
    protected void result(Object object) {
        if (object.equals(true)){
            hide();
        }
    }
}
