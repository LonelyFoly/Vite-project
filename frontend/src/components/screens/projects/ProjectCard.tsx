import {Card} from "antd";
import styles from "./ProjectCard.module.css"

const ProjectCard = () => {
    return (
        <Card className={styles.card}>
            <h2>НП-1</h2>
            <h2>Название проекта</h2>
            <p>Руководитель проекта: Фамилия Имя</p>
            <p>Дедлайн: 1 дек. 2023</p>
        </Card>
    );
};

export default ProjectCard;