import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
		File file = new File(args[0]);

		BufferedReader in = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = in.readLine()) != null) {
			Map<String, User> users = setUpUsers();

			String[] inputArray = line.split("\\s+");

			boolean hasPermission = true;

			for (String input : inputArray) {
				String[] inputCode = input.split("=>");

				String performingUser = inputCode[0];
				String fileName = inputCode[1];
				String action = inputCode[2];

				User user = users.get(performingUser);

				hasPermission = checkUserPermission(user, fileName, action);

				if (!hasPermission) {
					System.out.println("False");

					break;
				}

				if (inputCode.length == 5) {
					String grantingAction = inputCode[3];
					String receivingUser = inputCode[4];

					user = users.get(receivingUser);

					grantUserPermission(user, fileName, grantingAction);
				}
			}

			if (hasPermission) {
				System.out.println("True");
			}
		}
	}

	private static boolean checkUserPermission(
		User user, String fileName, String action) {

		SecureFile file = user.getFile(fileName);

		if (action.equals(_GRANT_KEY)) {
			return file.canGrant();
		}
		else if (action.equals(_WRITE_KEY)) {
			return file.canWrite();
		}
		else {
			return file.canRead();
		}
	}

	private static void grantUserPermission(
		User user, String fileName, String action) {

		SecureFile file = user.getFile(fileName);

		if (action.equals(_GRANT_KEY)) {
			file.setCanGrant(true);
		}
		else if (action.equals(_WRITE_KEY)) {
			file.setCanWrite(true);
		}
		else {
			file.setCanRead(true);
		}
	}

	private static void setUpUser(
		Map<String, User> users, String userName, SecureFile firstFile,
		SecureFile secondFile, SecureFile thirdFile) {

		Map<String, SecureFile> fileAccess = new HashMap<>();

		fileAccess.put("file_1", firstFile);
		fileAccess.put("file_2", secondFile);
		fileAccess.put("file_3", thirdFile);

		users.put(userName, new User(fileAccess));
	}

	private static Map<String, User> setUpUsers() {

		/*
		For some reason, CodeEval fails the compilation after 10 seconds when
		the static secure files are used, thus necessitating create a new
		SecureFile based off of an already made SecureFile. Outside of CodeEval,
		this code could be improved significantly, but due to that limitation
		as well as needing to reuse the files this is currently necessary.
		 */

		Map<String, User> users = new HashMap<>();

		SecureFile firstFile = new SecureFile(_FULL_ACCESS);
		SecureFile secondFile = new SecureFile(_WRITE_GRANT);
		SecureFile thirdFile = new SecureFile(_TOTAL_BAN);

		setUpUser(users, "user_1", firstFile, secondFile, thirdFile);

		firstFile = new SecureFile(_READ_WRITE);
		secondFile = new SecureFile(_WRITE);
		thirdFile = new SecureFile(_READ);

		setUpUser(users, "user_2", firstFile, secondFile, thirdFile);

		firstFile = new SecureFile(_READ_GRANT);
		secondFile = new SecureFile(_GRANT);
		thirdFile = new SecureFile(_READ_GRANT);

		setUpUser(users, "user_3", firstFile, secondFile, thirdFile);

		firstFile = new SecureFile(_WRITE_GRANT);
		secondFile = new SecureFile(_FULL_ACCESS);
		thirdFile = new SecureFile(_GRANT);

		setUpUser(users, "user_4", firstFile, secondFile, thirdFile);

		firstFile = new SecureFile(_READ_WRITE);
		secondFile = new SecureFile(_TOTAL_BAN);
		thirdFile = new SecureFile(_WRITE);

		setUpUser(users, "user_5", firstFile, secondFile, thirdFile);

		firstFile = new SecureFile(_READ);
		secondFile = new SecureFile(_WRITE);
		thirdFile = new SecureFile(_READ_WRITE);

		setUpUser(users, "user_6", firstFile, secondFile, thirdFile);

		return users;
	}

	private static class User {
		public User(Map<String, SecureFile> fileAccess) {
			_fileAccess = fileAccess;
		}

		private SecureFile getFile(String fileName) {
			return _fileAccess.get(fileName);
		}

		private Map<String, SecureFile> _fileAccess;
	}

	private static class SecureFile {
		public SecureFile(boolean canGrant, boolean canWrite,boolean canRead) {
			_canGrant = canGrant;
			_canWrite = canWrite;
			_canRead = canRead;
		}

		public SecureFile(SecureFile secureFile) {
			_canGrant = secureFile.canGrant();
			_canWrite = secureFile.canWrite();
			_canRead = secureFile.canRead();
		}

		private boolean canGrant() {
			return _canGrant;
		}

		private boolean canWrite() {
			return _canWrite;
		}

		private boolean canRead() {
			return _canRead;
		}

		private void setCanGrant(boolean canGrant) {
			_canGrant = canGrant;
		}

		private void setCanWrite(boolean canWrite) {
			_canWrite = canWrite;
		}

		private void setCanRead(boolean canRead) {
			_canRead = canRead;
		}

		private boolean _canGrant;
		private boolean _canWrite;
		private boolean _canRead;
	}

	private static final SecureFile _TOTAL_BAN = new SecureFile(false, false, false);
	private static final SecureFile _GRANT = new SecureFile(true, false, false);
	private static final SecureFile _WRITE = new SecureFile(false, true, false);
	private static final SecureFile _WRITE_GRANT = new SecureFile(true, true, false);
	private static final SecureFile _READ = new SecureFile(false, false, true);
	private static final SecureFile _READ_GRANT = new SecureFile(true, false, true);
	private static final SecureFile _READ_WRITE = new SecureFile(false, true, true);
	private static final SecureFile _FULL_ACCESS = new SecureFile(true, true, true);

	private static final String _GRANT_KEY = "grant";
	private static final String _WRITE_KEY = "write";
	private static final String _READ_KEY = "read";

}