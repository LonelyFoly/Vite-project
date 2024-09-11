import {Card} from "antd";
import styles from "./TaskCard.module.css"

const TaskCard = () => {
    return (
        <Card className={styles.card}>
            <h2>НП-1</h2>
            <h2>Название задачи</h2>
            <p>Исполнитель: Фамилия Имя</p>
            <p>Проверяющий: Фамилия Имя</p>
            <p>Дедлайн: 1 дек. 2023</p>
        </Card>
    );
};

export default TaskCard;