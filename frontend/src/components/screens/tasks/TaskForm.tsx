import {Card} from "antd";
import styles from "./TaskForm.module.css"
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import Select from 'react-select';
import ReactDOM from 'react-dom';

const typeOptions = [
    // подтянуть из бд
    { value: 'red', label: 'Красный' },
    { value: 'orange', label: 'Оранжевый' },
    { value: 'green', label: 'Зеленый' },
];
const teamOptions = [
    // подтянуть из бд
    { value: 'emp1', label: 'Сотрудник1' },
    { value: 'emp2', label: 'Сотрудник2' }
];

interface ProjectFormProps {
    onSubmit: () => void;
    onClose: () => void;
}

const TaskForm: React.FC<ProjectFormProps> = ({ onSubmit, onClose }) => {
    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        // Здесь добавить логику обработки отправки формы
        onSubmit(); // Вызываем onSubmit, переданный извне
    };

    return ReactDOM.createPortal(
        <Card className={styles.card}>
            <button className={styles.closeButton} onClick={onClose}>✕</button>
            <form onSubmit={handleSubmit}>
                <label>
                    Название:
                    <input
                        type="text"
                        name="name"
                        required
                    />
                </label>
                <label>
                    Сокращение:
                    <input
                        type="text"
                        name="name"
                        required
                    />
                </label>
                <label>
                    Описание:
                    <textarea
                        name="description"
                        required
                    />
                </label>
                <label>
                    Тип
                    <Select
                        options={typeOptions}
                    />
                </label>
                <label>
                    Исполнитель
                    <Select
                        options={teamOptions}
                    />
                </label>
                <label>
                    Дедлайн:
                    <DatePicker selected={new Date()} onChange={()=>{}}/>
                </label>
                <button className={styles.submitButton} type="submit">Создать задачу</button>
            </form>
        </Card>,
        document.body
    );
};

export default TaskForm;