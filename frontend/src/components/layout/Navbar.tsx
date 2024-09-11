//import React from 'react';

import {Link} from "react-router-dom";
import styles from "./Header.module.css";

const Navbar = () => {
    const setActiveLink = (event: React.MouseEvent<HTMLAnchorElement>) => {
        const target = event.currentTarget;

        // Удаляем класс "active" у всех элементов
        const links = document.querySelectorAll(`.${styles.active}`);
        links.forEach((link) => {
            link.classList.remove(styles.active);
        });

        // Добавляем класс "active" только к текущему элементу
        target.classList.add(styles.active);
    };
    return (
        <nav className={styles.nav}>
            <Link to={"/tasks"} onClick={setActiveLink}>Задачи</Link>
            <Link to={"/projects"} onClick={setActiveLink}>Проекты</Link>
            <Link to={"#"} onClick={setActiveLink}>Графики</Link>
            <Link to={"#"} onClick={setActiveLink}>Команды</Link>
            <Link to={"#"} onClick={setActiveLink}>Отчёты</Link>
        </nav>
    );
};

export default Navbar;