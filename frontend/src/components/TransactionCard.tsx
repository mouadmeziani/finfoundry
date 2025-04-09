import { Transaction } from "@/types/transaction";

type TransactionCardProps = {
  transaction: Transaction;
};

export default function TransactionCard({ transaction }: TransactionCardProps) {
  const { id, amount, description, date, type, category } = transaction;

  return (
    <article
      style={{ border: "1px solid #ccc", margin: "1rem 0", padding: "1rem" }}
    >
      <h2>{description}</h2>
      <p>
        <strong>ID:</strong> {id}
      </p>
      <p>
        <strong>Amount:</strong> ${amount.toFixed(2)}
      </p>
      <p>
        <strong>Date:</strong> {date}
      </p>
      <p>
        <strong>Type:</strong> {type}
      </p>
      {category && (
        <p>
          <strong>Category:</strong> {category.name}
        </p>
      )}
    </article>
  );
}
