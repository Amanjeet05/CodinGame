package com.crio.codingame.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.ContestStatus;
import com.crio.codingame.entities.RegisterationStatus;
import com.crio.codingame.entities.ScoreOrder;
import com.crio.codingame.entities.User;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.InvalidOperationException;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.repositories.IContestRepository;
import com.crio.codingame.repositories.IUserRepository;

public class UserService implements IUserService{

    private final IUserRepository userRepository;
    private final IContestRepository contestRepository;

    public UserService(IUserRepository userRepository, IContestRepository contestRepository) {
        this.userRepository = userRepository;
        this.contestRepository = contestRepository;
    }

    String id = "1";
    // TODO: CRIO_TASK_MODULE_SERVICES
    // Create and store User into the repository.
    @Override
    public User create(String name) {

        User u = new User(id,name,0);
        int z = Integer.parseInt(id);
        z++;
        id = String.valueOf(z);
        userRepository.save(u);
        return u;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Users in Ascending Order w.r.t scores if ScoreOrder ASC.
    // Or
    // Get All Users in Descending Order w.r.t scores if ScoreOrder DESC.

    @Override
    public List<User> getAllUserScoreOrderWise(ScoreOrder scoreOrder) throws InvalidOperationException {

        List<User> result = userRepository.findAll();
        Collections.sort(result);
        if(scoreOrder == ScoreOrder.ASC)
            return result;
        
        Collections.reverse(result);
        return result;
    }

    @Override
    public UserRegistrationDto attendContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException {
        Contest contest = contestRepository.findById(contestId).orElseThrow(ContestNotFoundException::new);
        User user = userRepository.findByName(userName).orElseThrow(UserNotFoundException::new);
        user.addContest(contest);
        userRepository.save(user);
        return new UserRegistrationDto(contest.getName(), user.getName(),RegisterationStatus.REGISTERED);
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Withdraw the user from the contest
    // Hint :- Refer Unit Testcases withdrawContest method

    @Override
    public UserRegistrationDto withdrawContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException {
     
        Contest contest = contestRepository.findById(contestId).orElseThrow(ContestNotFoundException::new);
        User user = userRepository.findByName(userName).orElseThrow(UserNotFoundException::new);

        if((contest.getContestStatus() == ContestStatus.IN_PROGRESS) || (contest.getContestStatus() == ContestStatus.ENDED)
         || ((contest.getCreator().getName()).equalsIgnoreCase(userName)))
            throw new InvalidOperationException();

        user.deleteContest(contest);
        userRepository.save(user);
        return new UserRegistrationDto(contest.getName(), user.getName(), RegisterationStatus.NOT_REGISTERED);
    }
    
}
