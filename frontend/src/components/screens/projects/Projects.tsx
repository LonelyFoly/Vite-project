//import React from 'react';

import Header from "../../layout/Header.tsx";
import styles from "./Projects.module.css";
import Button from "../../ui/Buttons/Button.tsx";
import {useState} from "react";
import ProjectForm from "./ProjectForm.tsx";
import ProjectCard from "./ProjectCard.tsx";

const Projects = () => {
    const [isProjectFormOpen, setIsProjectFormOpen] = useState(false);

    const openProjectForm = () => {
        setIsProjectFormOpen(true);
    };

    const closeProjectForm = () => {
        setIsProjectFormOpen(false);
    };

    return (
        <div>
            <Header/>
            <div className={styles.body}>
                <h1 className={styles.h1}>Проекты</h1>
                <Button text={"+ Новый проект"} onClick={openProjectForm}/>
                <Button text={"+ Новый шаблон"} onClick={() => {}}/>
                <ProjectCard/>
                <ProjectCard/>
                <ProjectCard/>
                {isProjectFormOpen && (
                    <div className={styles.modalOverlay}>
                        <div className={styles.modalContent}>
                            {/* Вставляем ProjectForm внутри модального окна */}
                            <ProjectForm onClose={closeProjectForm} onSubmit={closeProjectForm} />
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Projects;