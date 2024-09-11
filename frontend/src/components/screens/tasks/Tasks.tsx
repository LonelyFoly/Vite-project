//import React from 'react';

import Header from "../../layout/Header.tsx";
import Button from "../../ui/Buttons/Button.tsx";
import styles from "./Tasks.module.css";
import {useState} from "react";
import TaskCard from "./TaskCard.tsx";
import TaskForm from "./TaskForm.tsx";

const Tasks = () => {
    const [isTaskFormOpen, setIsTaskFormOpen] = useState(false);

    const openTaskForm = () => {
        setIsTaskFormOpen(true);
    };

    const closeTaskForm = () => {
        setIsTaskFormOpen(false);
    };
    return (
        <div>
            <Header/>
            <div className={styles.body}>
                <h1 className={styles.h1}>Задачи</h1>
                <Button text={"+ Новый задача"} onClick={openTaskForm}/>
                <Button text={"+ Новый шаблон"} onClick={() => {}}/>
                <TaskCard/>
                {isTaskFormOpen && (
                    <div className={styles.modalOverlay}>
                        <div className={styles.modalContent}>
                            {/* Вставляем TaskForm внутри модального окна */}
                            <TaskForm onClose={closeTaskForm} onSubmit={closeTaskForm} />
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Tasks;