import { Box, Heading, Text } from "@chakra-ui/react";
import { Transaction } from "@/types/transaction";

type TransactionCardProps = {
  transaction: Transaction;
};

export default function TransactionCard({ transaction }: TransactionCardProps) {
  const { id, amount, description, date, type, category } = transaction;

  return (
    <Box borderWidth="1px" borderRadius="md" p="4" mb="4" boxShadow="sm">
      <Heading size="md" mb="2">
        {description}
      </Heading>
      <Text>
        <strong>ID:</strong> {id}
      </Text>
      <Text>
        <strong>Amount:</strong> ${amount.toFixed(2)}
      </Text>
      <Text>
        <strong>Date:</strong> {date}
      </Text>
      <Text>
        <strong>Type:</strong> {type}
      </Text>
      {category && (
        <Text>
          <strong>Category:</strong> {category.name}
        </Text>
      )}
    </Box>
  );
}
