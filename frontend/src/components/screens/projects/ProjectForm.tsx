import {Card} from "antd";
import styles from "./ProjectForm.module.css"
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import Select from 'react-select';
import ReactDOM from 'react-dom';

const typeOptions = [
    { value: 'Open', label: 'Всем' },
    { value: 'Closed', label: 'Участникам' },
    { value: 'Secret', label: 'Никому' },
];
const teamOptions = [
    { value: 'team1', label: 'Команда1' },
    { value: 'team2', label: 'Команда2' }
];

interface ProjectFormProps {
    onSubmit: () => void;
    onClose: () => void;
}

const ProjectForm: React.FC<ProjectFormProps> = ({ onSubmit, onClose }) => {
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
                    Доступен
                    <Select
                        options={typeOptions}
                    />
                </label>
                <label>
                    Команда
                    <Select
                        options={teamOptions}
                    />
                </label>
                <label>
                    Дедлайн:
                    <DatePicker selected={new Date()} onChange={()=>{}}/>
                </label>
                <button className={styles.submitButton} type="submit">Создать проект</button>
            </form>
        </Card>,
            document.body
    );
};

export default ProjectForm;